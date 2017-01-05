package com.emmairving.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by irving on 17/1/5.
 */
@SpringBootApplication
//@RestController
public class Bootstrap {
    // mvn spring-boot:run 执行
    // mvn package 打包

    // 一个项目中main函数只能有一个，否则会报错
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

//    @RequestMapping("/")
//    public String hello() {
//        return "Hello World!";
//    }
}
