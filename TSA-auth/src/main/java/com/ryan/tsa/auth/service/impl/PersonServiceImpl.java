package com.ryan.tsa.auth.service.impl;

import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.mapper.PersonMapper;
import com.ryan.tsa.auth.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author ryan
 * @since 2021-04-28
 */
@Service
@Slf4j
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
