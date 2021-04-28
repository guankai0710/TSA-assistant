package com.ryan.tsa.miniapp.product.mapper;

import com.ryan.tsa.miniapp.product.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 产品信息  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Repository
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
