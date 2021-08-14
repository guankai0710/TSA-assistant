package com.ryan.tsa.auth.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.mapper.PersonMapper;
import com.ryan.tsa.auth.qo.PersonQo;
import com.ryan.tsa.auth.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryan.tsa.common.domain.SysDictionary;
import com.ryan.tsa.common.exception.BusinessException;
import com.ryan.tsa.common.response.PageResponse;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.utils.EncoderOfMd5Util;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author Ryan
 * @since 2021-08-13
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Override
    public PageResponse<Person> pageList(PersonQo qo) {
        try {
            QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(qo.getNameOrAccount())){
                queryWrapper.lambda()
                        .like(Person::getName,qo.getNameOrAccount()).or()
                        .like(Person::getAccount,qo.getNameOrAccount());
            }
            if (qo.getRoleId() != null){
                queryWrapper.lambda().eq(Person::getRoleId,qo.getRoleId());
            }
            if (qo.getEnabled() != null){
                queryWrapper.lambda().eq(Person::getEnabled,qo.getEnabled());
            }
            if (qo.getOnlined() != null){
                queryWrapper.lambda().eq(Person::getOnlined,qo.getOnlined());
            }
            if (StringUtils.isNotBlank(qo.getOrder())){
                queryWrapper.orderBy(true,qo.getSort(),
                        Person.class.getDeclaredField(qo.getOrder()).getAnnotation(TableField.class).value());
            } else {
                queryWrapper.lambda().orderByDesc(Person::getCreatedTime);
            }
            Page<Person> page = new Page<>(qo.getPageNum(), qo.getPageSize());
            return PageResponse.of(baseMapper.selectPage(page,queryWrapper));
        } catch (NoSuchFieldException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public List<Map<String, Object>> dropDownList() {
        return baseMapper.dropDownList();
    }

    @Override
    public Person getByAccount(String account) {
        LambdaQueryWrapper<Person> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Person::getAccount,account);
        List<Person> personList = baseMapper.selectList(lambdaQueryWrapper);
        return personList.isEmpty()?null:personList.get(0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Person person) {
        if (person.getRoleId() == null || StringUtils.isBlank(person.getName()) ||
            StringUtils.isBlank(person.getAccount()) || StringUtils.isBlank(person.getPassword())){
            throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
        }
        try {
            String salt = RandomStringUtils.randomAlphabetic(32);
            //密码加密
            String password = EncoderOfMd5Util.getSaltMD5(person.getPassword(), salt);
            person.setEncryptsalt(salt);
            person.setPassword(password);
            baseMapper.insert(person);
            return true;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(Person person) {
        try {
            if (person.getPersonId() == null){
                throw new BusinessException(ResultCode.PARAM_NOT_EXIST);
            }
            baseMapper.updateById(person);
            return true;
        } catch (BusinessException e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updatePasswordById(Integer personId, String oldPassword, String newPassword) {
        try {
            Person person = baseMapper.selectById(personId);
            String existPassword = EncoderOfMd5Util.getSaltMD5(person.getPassword(), person.getEncryptsalt());
            if (!existPassword.equals(oldPassword)){
                throw  new BusinessException(ResultCode.PASSWORD_NOT_EXIST);
            }
            String salt = RandomStringUtils.randomAlphabetic(32);
            //密码加密
            String password = EncoderOfMd5Util.getSaltMD5(person.getPassword(), salt);
            person.setEncryptsalt(salt);
            person.setPassword(password);
            baseMapper.updateById(person);
            return true;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOnlined(Integer personId, Integer onlined) {
        try {
            Person person = new Person();
            person.setPersonId(personId);
            person.setOnlined(onlined);
            baseMapper.updateById(person);
            return true;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateEnabled(Integer personId, Integer enabled) {
        try {
            Person person = new Person();
            person.setPersonId(personId);
            person.setEnabled(enabled);
            baseMapper.updateById(person);
            return true;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }

}
