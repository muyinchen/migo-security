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

import com.migo.dao.UserDao;
import com.migo.entity.UserEntity;
import com.migo.service.UserService;
import com.migo.utils.RRException;
import com.migo.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 知秋
 * @email fei6751803@163.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryObject(Long userId){
        return userDao.queryObject(userId);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map){
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map){
        return userDao.queryTotal(map);
    }

    @Override
    public void save(UserEntity user){
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public void update(UserEntity user){
        userDao.update(user);
    }

    @Override
    public void delete(Long userId){
        userDao.delete(userId);
    }

    @Override
    public void deleteBatch(Long[] userIds){
        userDao.deleteBatch(userIds);
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    @Override
    public long login(String mobile, String password) {
        UserEntity user = queryByMobile(mobile);
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
            throw new RRException("手机号或密码错误");
        }

        return user.getUserId();
    }
}
