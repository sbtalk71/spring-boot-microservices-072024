package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Greeter greeter= (Greeter)ctx.getBean("greeter");
		
		System.out.println(greeter.getMessage().getGreetings());
		
		
Greeter greeter1= (Greeter)ctx.getBean("greeter");
		
		System.out.println(greeter1.getMessage().getGreetings());
		
		System.out.println(greeter==greeter1);
		

	}

}
