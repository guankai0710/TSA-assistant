package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.domain.Role;
import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.IRoleService;
import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/auth/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param order 排序字段
     * @param sort 排序方式 是否是 ASC 排序
     * @param name 角色名称
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam(value = "order",required = false) String order,
                           @RequestParam(value = "sort",required = false) Boolean sort,
                           @RequestParam(value = "name",required = false) String name){
        RoleQo qo = new RoleQo(pageNum, pageSize, order, sort, name);
        return Result.success(roleService.pageList(qo));
    }

    /**
     * 角色下拉列表
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/dropDownList")
    public Result dropDownList(){
        return Result.success(roleService.dropDownList());
    }

    /**
     * 新增
     *
     * @param role 用户信息
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PostMapping("save")
    public Result save(Role role){
        return Result.success(restResult(roleService.save(role)));
    }

    /**
     * 修改
     *
     * @param role 用户信息
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("update")
    public Result update(Role role){
        return Result.success(restResult(roleService.updateById(role)));
    }

    /**
     * 批量删除
     *
     * @param ids 用户ids
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @DeleteMapping("delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(roleService.removeByIds(Arrays.asList(ids))));
    }


}

