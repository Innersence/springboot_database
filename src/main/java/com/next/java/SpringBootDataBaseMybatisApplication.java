package com.next.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.next")
@MapperScan("com.next.java.mapper")
public class SpringBootDataBaseMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataBaseMybatisApplication.class, args);
	}
}
