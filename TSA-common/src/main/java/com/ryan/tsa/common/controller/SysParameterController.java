package com.ryan.tsa.common.controller;


import com.ryan.tsa.common.domain.SysParameter;
import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.service.ISysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-08-12
 */
@RestController
@RequestMapping("/common/sys-parameter")
public class SysParameterController extends BaseController {

    @Autowired
    private ISysParameterService sysParameterService;

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param order 排序字段
     * @param sort 排序方式 是否是 ASC 排序
     * @param paramCodeOrParamName 系统参数编码/系统参数名称
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam(value = "order",required = false) String order,
                           @RequestParam(value = "sort",required = false) Boolean sort,
                           @RequestParam(value = "paramCodeOrParamName",required = false) String paramCodeOrParamName){
        SysParameterQo qo = new SysParameterQo(pageNum, pageSize, order, sort, paramCodeOrParamName);
        return Result.success(sysParameterService.pageList(qo));
    }

    /**
     * 根据系统参数编码查询系统参数值
     *
     * @param paramCode 系统参数编码
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @GetMapping("/getParamValueByParamCode")
    public Result getParamValueByParamCode(@RequestParam("paramCode") String paramCode){
        return Result.success(sysParameterService.getParamValueByParamCode(paramCode));
    }

    /**
     * 新增
     *
     * @param sysParameter 系统参数
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PostMapping("/save")
    public Result save(SysParameter sysParameter){
        return Result.success(restResult(sysParameterService.save(sysParameter)));
    }

    /**
     * 修改
     *
     * @param sysParameter 系统参数
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @PutMapping("/update")
    public Result update(SysParameter sysParameter){
        return Result.success(restResult(sysParameterService.updateById(sysParameter)));
    }

    /**
     * 批量删除
     *
     * @param ids 系统参数ids
     * @author Ryan
     * @date 2021/8/14
     * @return
     **/
    @DeleteMapping("delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(sysParameterService.removeByIds(Arrays.asList(ids))));
    }


}

