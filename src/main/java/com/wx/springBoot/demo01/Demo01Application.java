package com.wx.springBoot.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//缓存注解
@EnableCaching
@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}

}
