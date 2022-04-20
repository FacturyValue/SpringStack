package com.rudy.demo.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @author heyahui
 * @date 2022-04-14
 *
 *
 * @MapperScan 专门用于扫描Mapper接口,如果不配置会报错.同时支持自定义Mapper文件扫描,利用basePackages扫描多个package
 */
@Configuration
@MapperScan(basePackages = "com.rudy.demo.tiny.mbg.mapper")
public class MyBatisConfig {

}

