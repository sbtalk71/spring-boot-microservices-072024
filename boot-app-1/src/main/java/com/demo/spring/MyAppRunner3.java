package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.spring.services.EmpService;

@Component
@PropertySource("classpath:myapp.properties")
public class MyAppRunner3 implements CommandLineRunner {

	@Autowired
	EmpService service;
	
	@Value("${driver}")
	String driver;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(service.addEmp(123, "A", "B", 3000));
		System.out.println("Driver : "+driver);

	}

}
