package com.ryan.tsa.auth.controller;


import com.alibaba.fastjson.JSON;
import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.service.PersonService;
import com.ryan.tsa.auth.vo.PersonVo;
import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.response.ResultCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户  前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/auth/person")
public class PersonController extends BaseController {

    @Autowired
    private PersonService personService;

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    @GetMapping("/pagelist")
    public Result pageList(PersonQo qo){
        return Result.success(personService.pageList(qo));
    }

    /**
     * 新增
     *
     * @param json 用户信息
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    @PostMapping("/save")
    public Result save(String json){
        return Result.success(restResult(personService.save(json)));
    }

    /**
     * 修改
     *
     * @param json 用户信息
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    @PostMapping("/update")
    public Result update(String json){
        Person person = JSON.parseObject(json,Person.class);
        if (person.getPersonId() == null){
            return Result.failure(ResultCode.PARAM_NOT_EXIST);
        }
        return Result.success(restResult(personService.updateById(person)));
    }

    /**
     * 修改密码
     *
     * @param personId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @author guankai
     * @date 2021/4/29
     * @return
     **/
    @PostMapping("/updatePwd")
    public Result updatePwd(@RequestParam("personId") Integer personId, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword){
        return Result.success(restResult(personService.updatePwd(personId, oldPassword, newPassword)));
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(personService.delete(ids)));
    }


}

