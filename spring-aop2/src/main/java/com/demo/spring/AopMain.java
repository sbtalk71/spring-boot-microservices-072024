package com.demo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		
		Performer performer=(Performer)ctx.getBean("singer");
		//Singer singer=ctx.getBean(Singer.class);
		
		/*
		 * System.out.println(singer.getClass().getName()); for(Method
		 * m:singer.getClass().getMethods()) { System.out.println(m.getName()); }
		 */
		
		performer.perform("John",25);

	}

}
