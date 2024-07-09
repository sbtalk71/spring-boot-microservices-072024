package com.demo.spring.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileDemoRunner implements CommandLineRunner {

	@Value("${app.profile:NO Profiles Active}")
	String profileName;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Profile Active : "+profileName);

	}

}
