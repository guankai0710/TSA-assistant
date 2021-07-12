package com.ryan.tsa.web.customer.mapper;

import com.ryan.tsa.web.customer.domain.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 客户信息  Mapper 接口
 * </p>
 *
 * @author ryan
 * @since 2021-07-12
 */
@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

}
