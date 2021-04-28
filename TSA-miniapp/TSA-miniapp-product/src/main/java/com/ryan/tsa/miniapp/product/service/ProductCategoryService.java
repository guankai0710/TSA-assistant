package com.ryan.tsa.miniapp.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.miniapp.product.domain.ProductCategory;
import com.ryan.tsa.miniapp.product.qo.ProductCategoryQo;
import com.ryan.tsa.miniapp.product.vo.ProductCategoryVo;

/**
 * <p>
 * 产品类别  服务类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    PageResponse<ProductCategoryVo> pageList(ProductCategoryQo qo);
}
