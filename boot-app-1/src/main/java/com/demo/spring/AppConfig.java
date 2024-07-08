package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.repository.EmpDao;
import com.demo.spring.repository.MockDaoImpl2;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class AppConfig {

	@Bean
	public EmpDao dao2() {
		return new MockDaoImpl2();
	}
}
