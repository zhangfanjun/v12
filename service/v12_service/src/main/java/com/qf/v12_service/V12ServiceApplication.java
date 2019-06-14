package com.qf.v12_service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.mapper")
@EnableDubbo
public class V12ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(V12ServiceApplication.class, args);
    }

}
