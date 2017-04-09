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

import com.migo.entity.SysConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息Service
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public interface SysConfigService {
    /**
     * 保存配置信息
     */
    public void save(SysConfigEntity config);

    /**
     * 更新配置信息
     */
    public void update(SysConfigEntity config);

    /**
     * 根据key，更新value
     */
    public void updateValueByKey(String key, String value);

    /**
     * 删除配置信息
     */
    public void deleteBatch(Long[] ids);

    /**
     * 获取List列表
     */
    public List<SysConfigEntity> queryList(Map<String, Object> map);
    /**
     * 获取总记录数
     */
    public int queryTotal(Map<String, Object> map);

    public SysConfigEntity queryObject(Long id);

    /**
     * 根据key，获取配置的value值
     *
     * @param key           key
     * @param defaultValue  缺省值
     */
    public String getValue(String key, String defaultValue);

    /**
     * 根据key，获取value的Object对象
     * @param key    key
     * @param clazz  Object对象
     */
    public <T> T getConfigObject(String key, Class<T> clazz);

}
