package com.ryan.tsa.web.customer.service.impl;

import com.ryan.tsa.web.customer.domain.Customer;
import com.ryan.tsa.web.customer.mapper.CustomerMapper;
import com.ryan.tsa.web.customer.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
