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

import com.migo.dao.SysUserRoleDao;
import com.migo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {


    @Autowired
    private SysUserRoleDao sysUserRoleDao;


    @Override
    @Transactional
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if(roleIdList.size() == 0){
            return ;
        }

        //先删除用户与角色关系
        sysUserRoleDao.delete(userId);

        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleDao.save(map);
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleDao.queryRoleIdList(userId);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        sysUserRoleDao.delete(userId);
    }
}
