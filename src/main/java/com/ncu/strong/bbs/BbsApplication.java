package com.ncu.strong.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.ncu.strong.bbs.dao")
@ComponentScan(basePackages = {"com.ncu.strong.bbs.*"})

@SpringBootApplication
public class BbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsApplication.class, args);
    }
}