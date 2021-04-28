package com.ryan.tsa.miniapp.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.miniapp.product.domain.Product;
import com.ryan.tsa.miniapp.product.mapper.ProductMapper;
import com.ryan.tsa.miniapp.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品信息  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
