package com.ryan.tsa.auth.service.impl;

import com.ryan.tsa.auth.domain.Person;
import com.ryan.tsa.auth.service.LoginService;
import com.ryan.tsa.auth.service.PersonService;
import com.ryan.tsa.auth.vo.LoginVo;
import com.ryan.tsa.common.enumerate.Sex;
import com.ryan.tsa.common.enumerate.YesOrNo;
import com.ryan.tsa.common.response.Result;
import com.ryan.tsa.common.response.ResultCode;
import com.ryan.tsa.common.utils.EncoderOfMd5Util;
import com.ryan.tsa.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：登录、注册、退出
 *
 * @author guankai
 * @date 2021/4/29
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PersonService personService;

    @Override
    public Result login(String account, String password) {
        Person person = personService.getByAccount(account);
        if (person == null){
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
        if (YesOrNo.NO.getValue().equals(person.getEnabled())){
            return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }
        String enPassword = EncoderOfMd5Util.getSaltMD5(password, person.getEncryptsalt());
        if (!enPassword.equals(person.getPassword())){
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
        //生成token
        Map<String,Object> map = new HashMap<>(16);
        map.put("personId",person.getPersonId());
        map.put("account",person.getAccount());
        map.put("roleId",person.getRoleId());
        String token = JwtUtil.createToken("TSA", map);
        LoginVo loginVo = new LoginVo(person.getName(), person.getAvatar(), person.getSex(), Sex.getByValue(person.getSex()).getName(), token);
        personService.updateOnlined(person.getPersonId(),YesOrNo.YES.getValue());
        return Result.success(loginVo);
    }

}
