package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class EmpProfilesJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpProfilesJdbcApplication.class, args);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	@Bean
	public DataSourceTransactionManager txManager(DataSource ds) {

		DataSourceTransactionManager txm = new DataSourceTransactionManager(ds);
		return txm;
	}

	@Bean
	public TransactionTemplate txTemplate(DataSourceTransactionManager txm) {
		TransactionTemplate ttmp = new TransactionTemplate(txm);
		return ttmp;
	}
}
