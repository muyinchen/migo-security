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

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传 Entity
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
public class SysOssEntity implements Serializable {

    private static final long serialVersionUID = 3239257985634924697L;


    private Long id;
    //URL地址
    private String url;
    //创建时间
    private Date createDate;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：URL地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * 获取：URL地址
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }
}
