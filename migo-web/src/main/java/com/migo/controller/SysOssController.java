/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.migo.controller;

import com.alibaba.fastjson.JSON;
import com.migo.entity.SysOssEntity;
import com.migo.oss.CloudStorageConfig;
import com.migo.oss.OSSFactory;
import com.migo.service.SysConfigService;
import com.migo.service.SysOssService;
import com.migo.utils.*;
import com.migo.validator.ValidatorUtils;
import com.migo.validator.group.AliyunGroup;
import com.migo.validator.group.QcloudGroup;
import com.migo.validator.group.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文件上传 Controller
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {

    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<SysOssEntity> sysOssList = sysOssService.queryList(query);
        int total = sysOssService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 云存储配置信息
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


    /**
     * 保存云存储配置信息
     */
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public R saveConfig(@RequestBody CloudStorageConfig config){
        //校验类型
        ValidatorUtils.validateEntity(config);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }


        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return R.ok();
    }


    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @RequiresPermissions("sys:oss:all")
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }

        //上传文件
        String url = OSSFactory.build().upload(file.getBytes());

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        return R.ok().put("url", url);
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public R delete(@RequestBody Long[] ids){
        sysOssService.deleteBatch(ids);

        return R.ok();
    }
}
