package com.ryan.tsa.common.controller;


import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.service.ISysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统字典 前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@RestController
@RequestMapping("/common/sys-dictionary")
public class SysDictionaryController {

    @Autowired
    private ISysDictionaryService sysDictionaryService;

    /**
     * 分页查询
     *
     * @param qo 查询条件
     * @author Ryan
     * @date 2021/8/13
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(SysDictionaryQo qo){
        return Result.success(sysDictionaryService.pageList(qo));
    }

}

