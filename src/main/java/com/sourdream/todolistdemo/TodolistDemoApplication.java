package com.sourdream.todolistdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sourdream.todolistdemo.mapper") // 扫描所有 Mapper 接口
public class TodolistDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistDemoApplication.class, args);
    }

}
