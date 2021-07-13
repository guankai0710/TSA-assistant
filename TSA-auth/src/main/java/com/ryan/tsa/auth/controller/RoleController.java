package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.qo.RoleQo;
import com.ryan.tsa.auth.service.RoleService;
import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/auth/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    @GetMapping("/pagelist")
    public Result pageList(RoleQo qo){
        return Result.success(roleService.pageList(qo));
    }

    /**
     * 新增
     *
     * @param roleName 角色名称
     * @param memo 备注
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    @PostMapping("/save")
    public Result save(@RequestParam("roleName") String roleName, @RequestParam(value = "memo", required = false) String memo){
        return Result.success(restResult(roleService.save(roleName, memo)));
    }

    /**
     * 修改
     *
     * @param roleId 角色id
     * @param roleName 角色名称
     * @param memo 备注
     * @author ryan
     * @date 2021/4/29
     * @return
     **/
    @PutMapping("/update")
    public Result update(@RequestParam("roleId") Integer roleId, @RequestParam("roleName") String roleName, @RequestParam(value = "memo", required = false) String memo){
        return Result.success(restResult(roleService.update(roleId, roleName, memo)));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(roleService.bacthDelete(ids)));
    }

}

