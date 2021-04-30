package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.mapper.PersonMapper;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.service.PersonService;
import com.ryan.tsa.auth.vo.PersonVo;
import com.ryan.tsa.common.enumerate.YesOrNo;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.utils.EncoderOfMd5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public PageResponse<PersonVo> pageList(PersonQo qo) {
        PageHelper.startPage(qo.getPageNum(),qo.getPageSize());
        List<PersonVo> personVos = personMapper.queryList(qo);
        return PageResponse.of(personVos);
    }

    @Override
    public PersonVo getById(Integer personId) {
        Person person = personMapper.selectById(personId);
        PersonVo personVo = new PersonVo();
        BeanUtils.copyProperties(person,personVo);
        return personVo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(PersonVo vo) {
        String salt = RandomStringUtils.randomAlphabetic(32);
        //新增用户初始密码666666
        String password = EncoderOfMd5Util.getSaltMD5("666666", salt);
        Person person = new Person();
        BeanUtils.copyProperties(vo,person);
        person.setEncryptsalt(salt);
        person.setPassword(password);
        personMapper.insert(person);
        return true;
    }

    @Override
    public Person getByAccount(String account) {
        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Person::getAccount,account);
        queryWrapper.eq(Person::getDeleted,YesOrNo.NO.getValue());
        return personMapper.selectOne(queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOnlined(Integer personId, Integer onlined) {
        personMapper.updateOnlined(personId, onlined);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePwd(Integer personId, String oldPassword, String newPassword) {
        //校验旧密码是否正确
        Person person = personMapper.selectById(personId);
        if (!person.getPassword().equals(EncoderOfMd5Util.getSaltMD5(oldPassword, person.getEncryptsalt()))){
            return false;
        }
        String salt = RandomStringUtils.randomAlphabetic(32);
        //新增用户初始密码666666
        String password = EncoderOfMd5Util.getSaltMD5(newPassword, salt);
        Person person1 = new Person();
        person1.setPersonId(personId);
        person1.setPassword(password);
        person1.setEncryptsalt(salt);
        personMapper.updateById(person1);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean resetPwd(Integer personId) {
        String salt = RandomStringUtils.randomAlphabetic(32);
        //新增用户初始密码666666
        String password = EncoderOfMd5Util.getSaltMD5("666666", salt);
        Person person = new Person();
        person.setPersonId(personId);
        person.setPassword(password);
        person.setEncryptsalt(salt);
        personMapper.updateById(person);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean bacthDelete(String ids) {
        personMapper.bacthDelete(ids);
        return true;
    }
}
