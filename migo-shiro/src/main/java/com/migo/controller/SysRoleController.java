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

package com.migo.controller;

import com.migo.annotation.SysLog;
import com.migo.entity.SysRoleEntity;
import com.migo.service.SysRoleMenuService;
import com.migo.service.SysRoleService;
import com.migo.utils.Constant;
import com.migo.utils.PageUtils;
import com.migo.utils.Query;
import com.migo.utils.R;
import com.migo.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author 知秋
 * @email fei6751803@163.com
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 角色列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(@RequestParam Map<String, Object> params){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysRoleEntity> list = sysRoleService.queryList(query);
        int total = sysRoleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 角色列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public R select(){
        Map<String, Object> map = new HashMap<>();

        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if(getUserId() != Constant.SUPER_ADMIN){
            map.put("createUserId", getUserId());
        }
        List<SysRoleEntity> list = sysRoleService.queryList(map);

        return R.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId){
        SysRoleEntity role = sysRoleService.queryObject(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);

        return R.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody SysRoleEntity role){
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return R.ok();
    }

    /**
     * 修改角色
     */
    @SysLog("修改角色")
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@RequestBody SysRoleEntity role){
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.update(role);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds){
        sysRoleService.deleteBatch(roleIds);

        return R.ok();
    }
}
