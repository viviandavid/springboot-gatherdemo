package com.example.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@MapperScan("com.example.springbootmybatisplus.dao*")
@SpringBootApplication()
public class SpringBootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisplusApplication.class, args);
    }

}
