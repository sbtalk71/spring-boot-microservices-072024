package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				httpsec -> httpsec.requestMatchers("/user").hasAnyRole("USER", "ADMIN").requestMatchers("/admin")
						.hasRole("ADMIN").requestMatchers("/authenticate").permitAll().anyRequest().authenticated());
				//.httpBasic(Customizer.withDefaults());

		return http.build();
	}

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

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

}
