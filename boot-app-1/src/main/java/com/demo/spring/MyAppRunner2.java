package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.services.EmpService;

@Component

public class MyAppRunner2 implements CommandLineRunner {

	@Autowired
	EmpService service;

	@Value("${message}")
	String msg;

	@Value("${driver}")
	String driver;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println(service.addEmp(100, "C", "D", 5000));
		System.out.println("Message is " + msg);
		System.out.println("Driver : "+driver);

	}

}
