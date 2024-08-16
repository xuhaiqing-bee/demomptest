package com.alibaba.demomptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alibaba.demomptest.mapper")
public class DemomptestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemomptestApplication.class, args);
    }

}
