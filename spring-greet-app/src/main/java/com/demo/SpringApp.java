package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		Greeter greeter= (Greeter)ctx.getBean("greeter");
		
		System.out.println(greeter.getMessage().getGreetings());
		
		
		/*
		 * Greeter greeter1= ctx.getBean(Greeter.class);
		 * 
		 * System.out.println(greeter1.getMessage().getGreetings());
		 * 
		 * 
		 * System.out.println("is Singleton? "+(greeter==greeter1));
		 */

	}

}
