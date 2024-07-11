package com.demo.spring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 http
				.authorizeHttpRequests(httpsec->httpsec.requestMatchers("/user").hasRole("USER").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
		
        return http.build();
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		//encoded password is 'welcome1'
		auth.inMemoryAuthentication().withUser("pavan").password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER");
		auth.inMemoryAuthentication().withUser("shantanu").password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("arun").password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER").disabled(true);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
		
	}
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("user") .password("password")
	 * .roles("USER") .build(); return new InMemoryUserDetailsManager(user); }
	 */
}
