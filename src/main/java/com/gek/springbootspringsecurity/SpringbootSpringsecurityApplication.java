package com.gek.springbootspringsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gek.springbootspringsecurity.mapper")
public class SpringbootSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityApplication.class, args);
    }

}
