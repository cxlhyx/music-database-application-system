package com.example.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.music.mapper")    //指定Mapper接口所在的包,将它们自动注册为Spring Bean,无需每个Mapper接口都单独使用@Mapper注解
public class MusicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MusicApplication.class, args);
        Environment env = run.getEnvironment();
        System.out.println("The system started successfully...");
        System.out.println("System access address:http://localhost:" + env.getProperty("server.port") + "/index");
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
