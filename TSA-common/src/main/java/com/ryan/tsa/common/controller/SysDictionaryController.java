package com.ryan.tsa.common.controller;


import com.ryan.tsa.common.qo.SysDictionaryQo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统字典  前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/common/sys-dictionary")
public class SysDictionaryController extends BaseController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    /**
     * 分页查询列表
     *
     * @param qo 查询条件
     * @author ryan
     * @date 2021/7/13
     * @return
     **/
    @GetMapping("/pageList")
    public Result pageList(SysDictionaryQo qo){
        return Result.success(sysDictionaryService.pageList(qo));
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
        return Result.success(restResult(sysDictionaryService.save(json)));
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
        return Result.success(restResult(sysDictionaryService.update(json)));
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
        return Result.success(restResult(sysDictionaryService.delete(ids)));
    }

    /**
     * 根据字典类型编码获取字典值
     *
     * @param typeCode 字典类型编码
     * @author ryan
     * @date 2021/4/30
     * @return
     **/
    @GetMapping("/{typeCode}")
    public Result getByTypeCode(@PathVariable String typeCode){
        return Result.success(sysDictionaryService.getByTypeCode(typeCode));
    }

}

