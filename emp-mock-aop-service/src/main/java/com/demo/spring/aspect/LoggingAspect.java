package com.demo.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com..services.EmpService.addEmp(..))")
	public void pcut() {}
	
	@Before("pcut()")
	public void logBefore() {
		System.out.println("Logging before method...");
	}
	
	@AfterReturning(pointcut = "pcut()")
	public void logAfter() {
		System.out.println("Logging After method returns...");
	}
	
	
}
