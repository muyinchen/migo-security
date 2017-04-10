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

import com.migo.dao.SysOssDao;
import com.migo.entity.SysOssEntity;
import com.migo.service.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service
public class SysOssServiceImpl implements SysOssService {

    @Autowired
    private SysOssDao sysOssDao;

    @Override
    public SysOssEntity queryObject(Long id){
        return sysOssDao.queryObject(id);
    }

    @Override
    public List<SysOssEntity> queryList(Map<String, Object> map){
        return sysOssDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return sysOssDao.queryTotal(map);
    }

    @Override
    public void save(SysOssEntity sysOss){
        sysOssDao.save(sysOss);
    }

    @Override
    public void update(SysOssEntity sysOss){
        sysOssDao.update(sysOss);
    }

    @Override
    public void delete(Long id){
        sysOssDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids){
        sysOssDao.deleteBatch(ids);
    }
}
