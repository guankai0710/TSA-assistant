package com.ryan.tsa.miniapp.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.miniapp.product.domain.ProductCategory;
import com.ryan.tsa.miniapp.product.mapper.ProductCategoryMapper;
import com.ryan.tsa.miniapp.product.qo.ProductCategoryQo;
import com.ryan.tsa.miniapp.product.service.ProductCategoryService;
import com.ryan.tsa.miniapp.product.vo.ProductCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品类别  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public PageResponse<ProductCategoryVo> pageList(ProductCategoryQo qo) {
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize());
        List<ProductCategoryVo> productCategoryVos = productCategoryMapper.pageList(qo);
        return PageResponse.of(productCategoryVos);
    }

}
