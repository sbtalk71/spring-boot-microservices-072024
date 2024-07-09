package com.demo.spring.profiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MyAppConfig implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyAppConfig Loaded in Dev Profile");
		
	}

}
