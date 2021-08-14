package com.ryan.tsa.auth.controller;


import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.service.IPersonService;
import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/auth/person")
public class PersonController extends BaseController {

    @Autowired
    private IPersonService personService;

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param order 排序字段
     * @param sort 排序方式 是否是 ASC 排序
     * @param roleId 角色id
     * @param nameOrAccount 用户名称/账号
     * @param onlined 是否在线
     * @param enabled 是否启用
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam(value = "order",required = false) String order,
                           @RequestParam(value = "sort",required = false) Boolean sort,
                           @RequestParam(value = "roleId",required = false) Integer roleId,
                           @RequestParam(value = "nameOrAccount",required = false) String nameOrAccount,
                           @RequestParam(value = "onlined",required = false) Integer onlined,
                           @RequestParam(value = "enabled",required = false) Integer enabled){
        PersonQo qo = new PersonQo(pageNum, pageSize, order, sort, roleId, nameOrAccount, onlined, enabled);
        return Result.success(personService.pageList(qo));
    }

    /**
     * 用户下拉列表
     *
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/dropDownList")
    public Result dropDownList(){
        return Result.success(personService.dropDownList());
    }

    /**
     * 新增
     *
     * @param person 用户信息
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PostMapping("save")
    public Result save(Person person){
        return Result.success(restResult(personService.save(person)));
    }

    /**
     * 修改
     *
     * @param person 用户信息
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("update")
    public Result update(Person person){
        return Result.success(restResult(personService.updateById(person)));
    }

    /**
     * 修改密码
     *
     * @param personId 用户id
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("updatePassword")
    public Result updatePassword(@RequestParam("personId") Integer personId,
                                 @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword){
        return Result.success(restResult(personService.updatePasswordById(personId, oldPassword, newPassword)));
    }

    /**
     * 修改用户启用状态
     *
     * @param personId 用户id
     * @param enabled 启用状态
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("updateEnabled")
    public Result updateEnabled(@RequestParam("personId") Integer personId, @RequestParam("enabled") Integer enabled){
        return Result.success(restResult(personService.updateEnabled(personId, enabled)));
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
        return Result.success(restResult(personService.removeByIds(Arrays.asList(ids))));
    }


}

