package com.ryan.tsa.common.controller;


import com.ryan.tsa.common.qo.SysParameterQo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.service.SysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统参数  前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/common/sys-parameter")
public class SysParameterController extends BaseController {

    @Autowired
    private SysParameterService sysParameterService;

    /**
     * 分页查询列表
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(SysParameterQo qo){
        return Result.success(sysParameterService.pageList(qo));
    }

    /**
     * 新增
     *
     * @param json 系统字典json字符串
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    @PostMapping("/save")
    public Result save(@RequestParam("json") String json){
        return Result.success(restResult(sysParameterService.save(json)));
    }

    /**
     * 修改
     *
     * @param json 系统字典json字符串
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    @PutMapping("/update")
    public Result update(@RequestParam("json") String json){
        return Result.success(restResult(sysParameterService.update(json)));
    }

    /**
     * 批量删除
     *
     * @param ids 主键ids
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("ids") String ids){
        return Result.success(restResult(sysParameterService.delete(ids)));
    }

    /**
     * 根据参数编码查询
     *
     * @param paramCode 参数编码
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    @GetMapping("/{paramCode}")
    public Result getByParamCode(@PathVariable String paramCode){
        return Result.success(sysParameterService.getByParamCode(paramCode));
    }

}

