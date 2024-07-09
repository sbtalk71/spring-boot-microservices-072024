package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Component
public class JpaRunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		Emp emp = new Emp(122, "Naren", "Ranchi", 67000);
		em.persist(emp);
	}

}
