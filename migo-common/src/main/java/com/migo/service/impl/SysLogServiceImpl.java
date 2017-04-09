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

import com.migo.dao.SysLogDao;
import com.migo.entity.SysLogEntity;
import com.migo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service
public class SysLogServiceImpl implements SysLogService {


    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public SysLogEntity queryObject(Long id){
        return sysLogDao.queryObject(id);
    }

    @Override
    public List<SysLogEntity> queryList(Map<String, Object> map){
        return sysLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return sysLogDao.queryTotal(map);
    }

    @Override
    public void save(SysLogEntity sysLog){
        sysLogDao.save(sysLog);
    }

    @Override
    public void update(SysLogEntity sysLog){
        sysLogDao.update(sysLog);
    }

    @Override
    public void delete(Long id){
        sysLogDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids){
        sysLogDao.deleteBatch(ids);
    }

}
