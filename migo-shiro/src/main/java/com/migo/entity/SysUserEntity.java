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

package com.migo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author   知秋
 * @email fei6751803@163.com
 */
@Data
public class SysUserEntity implements Serializable{
    private static final long serialVersionUID = -167607904051963460L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message="用户名不能为空"/*, groups = {AddGroup.class, UpdateGroup.class}*/)
    private String username;

    /**
     * 密码
     */
    @NotBlank(message="密码不能为空"/*, groups = AddGroup.class*/)
    private transient String password;

    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空"/*, groups = {AddGroup.class, UpdateGroup.class}*/)
    @Email(message="邮箱格式不正确"/*, groups = {AddGroup.class, UpdateGroup.class}*/)
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;
}
