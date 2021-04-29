package com.ryan.tsa.miniapp.product.controller;


import com.ryan.tsa.common.controller.BaseController;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.miniapp.product.qo.ProductCategoryQo;
import com.ryan.tsa.miniapp.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品类别  前端控制器
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/tsa/miniapp/product/product-category")
public class ProductCategoryController extends BaseController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/pagelist")
    public Result pageList(ProductCategoryQo qo){
        return Result.success(productCategoryService.pageList(qo));
    }

}

