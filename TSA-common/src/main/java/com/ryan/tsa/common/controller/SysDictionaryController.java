package com.ryan.tsa.common.controller;


import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.service.ISysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
public class SysDictionaryController extends BaseController {

    @Autowired
    private ISysDictionaryService sysDictionaryService;

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param order 排序字段
     * @param sort 排序方式 是否是 ASC 排序
     * @param typeCodeOrTypeName 字典类型编码/字典类型名称
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam(value = "order",required = false) String order,
                           @RequestParam(value = "sort",required = false) Boolean sort,
                           @RequestParam(value = "typeCodeOrTypeName",required = false) String typeCodeOrTypeName){
        SysDictionaryQo qo = new SysDictionaryQo(pageNum, pageSize, order, sort, typeCodeOrTypeName);
        return Result.success(sysDictionaryService.pageList(qo));
    }

    /**
     * 根据字典类型编码查询
     *
     * @param typeCode 字典类型编码
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/getByTypeCode")
    public Result getByTypeCode(@RequestParam("typeCode") String typeCode){
        return Result.success(sysDictionaryService.getByTypeCode(typeCode));
    }

    /**
     * 新增
     *
     * @param sysDictionary 系统字典
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PostMapping("/save")
    public Result save(SysDictionary sysDictionary){
        return Result.success(restResult(sysDictionaryService.save(sysDictionary)));
    }

    /**
     * 修改
     *
     * @param sysDictionary 系统字典
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("/update")
    public Result update(SysDictionary sysDictionary){
        return Result.success(restResult(sysDictionaryService.updateById(sysDictionary)));
    }

    /**
     * 批量删除
     *
     * @param ids 字典ids
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @DeleteMapping("delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(sysDictionaryService.removeByIds(Arrays.asList(ids))));
    }


}

