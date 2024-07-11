package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class OauthDemo1Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(OauthDemo1Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("Arun").password(passwordEncoder().encode("Arun123")).roles("USER");
		builder.inMemoryAuthentication().withUser("Pavan").password(passwordEncoder().encode("Pavan123"))
				.roles("ADMIN");
		builder.inMemoryAuthentication().withUser("Shantanu").password("Shan123")
				.roles("USER");
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
