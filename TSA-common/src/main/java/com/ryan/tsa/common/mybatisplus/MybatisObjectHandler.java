package com.ryan.tsa.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ryan.tsa.common.constant.DateTimeFormat;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * mybatis-plus自定义自动填充器
 * </p>
 *
 * @author Ryan
 * @since 2021-08-14
 */
@Component
public class MybatisObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat.TIME_YYYY_MM_DD_HH_MM_SS)), metaObject);
        this.setFieldValByName("updatedTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat.TIME_YYYY_MM_DD_HH_MM_SS)), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateTimeFormat.TIME_YYYY_MM_DD_HH_MM_SS)), metaObject);
    }
}
