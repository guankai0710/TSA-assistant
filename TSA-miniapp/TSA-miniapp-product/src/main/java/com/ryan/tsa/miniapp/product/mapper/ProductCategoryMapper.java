package com.ryan.tsa.miniapp.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryan.tsa.miniapp.product.domain.ProductCategory;
import com.ryan.tsa.miniapp.product.qo.ProductCategoryQo;
import com.ryan.tsa.miniapp.product.vo.ProductCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 产品类别  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<ProductCategoryVo> pageList(ProductCategoryQo qo);

}
