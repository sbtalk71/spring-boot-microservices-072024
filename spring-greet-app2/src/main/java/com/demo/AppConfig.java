package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = "com.demo")
public class AppConfig {

	@Bean
	@Lazy
	public Message message1() {
		Message msg = new Message();
		msg.setGreetings("Welcome to Spring");
		return msg;
	}
}
