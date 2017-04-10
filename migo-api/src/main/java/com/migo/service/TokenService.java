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

package com.migo.service;

import com.migo.entity.TokenEntity;

import java.util.Map;

/**
 * 用户Token Service
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public interface TokenService {

    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);

    void save(TokenEntity token);

    void update(TokenEntity token);

    /**
     * 生成token
     * @param userId  用户ID
     * @return        返回token相关信息
     */
    Map<String, Object> createToken(long userId);

}
