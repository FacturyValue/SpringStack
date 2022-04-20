package com.springboot.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class Helloworld {
    public static void main(String[] args){
        SpringApplication.run(Helloworld.class);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",defaultValue = "张三") String name){
        return "HelloWorld "+ name;
    }
}
