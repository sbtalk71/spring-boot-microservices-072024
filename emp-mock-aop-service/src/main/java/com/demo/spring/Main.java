package com.demo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.services.EmpService;


public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService service=(EmpService)ctx.getBean("empService");
		
		System.out.println(service.addEmp(123, "A", "B", 1234));
		
		System.out.println(service.getClass().getName());
		
		for(Method m : service.getClass().getMethods()) {
			System.out.println(m.getName());
		}

	}

}
