package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.spring.services.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//EmpService service=ctx.getBean(EmpService.class);
		
		//System.out.println(service.addEmp(123, "A", "B", 3000));
		
		//ctx.close();
	}

}
