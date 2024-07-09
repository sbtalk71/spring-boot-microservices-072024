package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class JpaRunner2 implements CommandLineRunner {

	@Autowired
	EmpRepository repository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Emp emp = new Emp(124, "Naren", "Ranchi", 90000);
		Emp saved = repository.save(emp);

		System.out.println(saved);

		/*
		 * Optional<Emp> empOp= repository.findById(121); if(empOp.isPresent())
		 * System.out.println(empOp.get());
		 * 
		 * 
		 * for(Emp e: repository.findAll()) { System.out.println(e); }
		 */
	}

}
