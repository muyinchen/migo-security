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

import com.migo.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志Service
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public interface SysLogService {

    SysLogEntity queryObject(Long id);

    List<SysLogEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysLogEntity sysLog);

    void update(SysLogEntity sysLog);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
