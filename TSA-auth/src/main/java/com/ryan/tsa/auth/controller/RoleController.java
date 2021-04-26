package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-23
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/page")
    public Result page(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return Result.success(roleService.page(pageNum,pageSize));
    }

}

