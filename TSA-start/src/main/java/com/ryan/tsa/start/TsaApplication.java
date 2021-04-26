package com.ryan.tsa.start;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动类
 */
@EnableTransactionManagement
@MapperScan(value = {"com.ryan.tsa.*.mapper"})
@SpringBootApplication(scanBasePackages = "com.ryan.tsa", exclude = DruidDataSourceAutoConfigure.class)
public class TsaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsaApplication.class, args);
    }
}
