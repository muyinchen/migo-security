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

package com.migo.service.impl;

import com.alibaba.fastjson.JSON;
import com.migo.dao.SysConfigDao;
import com.migo.entity.SysConfigEntity;
import com.migo.service.SysConfigService;
import com.migo.utils.RRException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public void save(SysConfigEntity config) {
        sysConfigDao.save(config);
    }

    @Override
    public void update(SysConfigEntity config) {
        sysConfigDao.update(config);
    }

    @Override
    public void updateValueByKey(String key, String value) {
        sysConfigDao.updateValueByKey(key, value);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysConfigDao.deleteBatch(ids);
    }

    @Override
    public List<SysConfigEntity> queryList(Map<String, Object> map) {
        return sysConfigDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysConfigDao.queryTotal(map);
    }

    @Override
    public SysConfigEntity queryObject(Long id) {
        return sysConfigDao.queryObject(id);
    }

    @Override
    public String getValue(String key, String defaultValue) {
        String value = sysConfigDao.queryByKey(key);
        if(StringUtils.isBlank(value)){
            return defaultValue;
        }
        return value;
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key, null);
        if(StringUtils.isNotBlank(value)){
            return JSON.parseObject(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RRException("获取参数失败");
        }
    }
}
