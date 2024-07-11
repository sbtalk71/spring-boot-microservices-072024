package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				httpsec -> httpsec.requestMatchers("/user").hasAnyRole("USER", "ADMIN").requestMatchers("/admin")
						.hasRole("ADMIN").requestMatchers("/info").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder
	 * auth)throws Exception{ //encoded password is 'welcome1'
	 * auth.inMemoryAuthentication().withUser("pavan").password(
	 * "$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER")
	 * ; auth.inMemoryAuthentication().withUser("shantanu").password(
	 * "$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("ADMIN"
	 * ); auth.inMemoryAuthentication().withUser("arun").password(
	 * "$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG").roles("USER")
	 * .disabled(true); }
	 */
	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails pavan =
	 * User .withUsername("pavan")
	 * .password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG")
	 * .roles("USER") .build(); UserDetails shantanu = User
	 * .withUsername("shantanu")
	 * .password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG")
	 * .roles("ADMIN") .build();
	 * 
	 * UserDetails arun = User .withUsername("arun")
	 * .password("$2a$10$td6KTADr4d4jB1/HxNzFxu3dRGaIANb6KFXOClywO7nUvzLmaHMJG")
	 * .roles("USER") .disabled(true) .build();
	 * 
	 * return new InMemoryUserDetailsManager(pavan,shantanu,arun); }
	 */
	/*
	 * @Autowired public void configureDbStore(AuthenticationManagerBuilder auth)
	 * throws Exception{ auth.jdbcAuthentication() .dataSource(dataSource) //queries
	 * are optional if using default schema
	 * .usersByUsernameQuery("select username,password,enabled from users where username=?"
	 * )
	 * .authoritiesByUsernameQuery("select username, authority from authorities where username=?"
	 * ); }
	 * 
	 */
	@Autowired
	public void configureLdapStore(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication()
				.contextSource()
				.url("ldap://localhost:10389/dc=jboss,dc=com")
				.managerDn("uid=admin,ou=system")
				.managerPassword("secret")
				.and()
				.userSearchBase("ou=users")
				.userSearchFilter("uid={0}")
				.groupSearchBase("ou=roles")
				.groupSearchFilter("uniqueMember={0}")
				.groupRoleAttribute("cn")
				.passwordCompare()
				.passwordEncoder(new LdapShaPasswordEncoder())
				.passwordAttribute("userPassword");
		System.out.println("LDAP initialized...");

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
