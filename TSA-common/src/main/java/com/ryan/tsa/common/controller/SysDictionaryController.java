package com.ryan.tsa.common.controller;


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
     * 根据字典类型编码获取字典值
     *
     * @param typeCode 字典类型编码
     * @author guankai
     * @date 2021/4/30
     * @return
     **/
    @GetMapping("/{typeCode}")
    public Result getByTypeCode(@PathVariable String typeCode){
        return Result.success(sysDictionaryService.getByTypeCode(typeCode));
    }

}

