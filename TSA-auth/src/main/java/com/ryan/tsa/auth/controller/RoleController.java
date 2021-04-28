package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.auth.vo.RoleVo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/pagelist")
    public Result pageList(RoleQo qo){
        return Result.success(roleService.pageList(qo));
    }
}

