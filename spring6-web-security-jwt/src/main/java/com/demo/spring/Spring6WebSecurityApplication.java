package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Spring6WebSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6WebSecurityApplication.class, args);
	}

	//because of circular dependency UserDetailsService is moved from SecurityConfig
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails pavan = User.withUsername("pavan")
				.password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER").build();
		UserDetails shantanu = User.withUsername("shantanu")
				.password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("ADMIN").build();

		UserDetails arun = User.withUsername("arun")
				.password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER").disabled(true)
				.build();

		return new InMemoryUserDetailsManager(pavan, shantanu, arun);
	}

}
