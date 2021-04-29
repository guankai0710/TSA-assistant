package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.mapper.PersonMapper;
import com.ryan.tsa.auth.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.common.enumerate.YesOrNo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    @Resource
    private PersonMapper personMapper;

    @Override
    public Person getByAccount(String account) {
        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Person::getAccount,account);
        return getOne(queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOnlined(Integer personId, Integer onlined) {
        personMapper.updateOnlined(personId, onlined);
        return true;
    }
}
