package com.ryan.tsa.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类描述：用户登录后返回数据
 *
 * @author guankai
 * @date 2021/4/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别(1:男；2:女)
     */
    private Integer sex;

    /**
     * 性别(1:男；2:女)
     */
    private String sexCn;

    /**
     * Token令牌
     */
    private String token;




}
