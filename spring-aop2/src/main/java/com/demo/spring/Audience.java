package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class Audience {
	
	@Pointcut("execution(* com..spring.*.*(..))")
	public void pcut() {}

	@Before("execution(* com..spring.*.*(..)) && args(name,..)")
		public void takeSeat(String name) {
		System.out.println("Audience taking seats for  "+name);
	}

	@Before("pcut()")
	public void switchOffMobiles() {
		System.out.println("Audience switched off their mobiles.... ");
	}

	@AfterReturning("execution(* com..spring.*.*(..)) && args(name1,..)")
	public void applaud(String name1) {
		System.out.println("Excellent Performance! "+name1+" Clap! Clap!... ");
	}
	
	
}
