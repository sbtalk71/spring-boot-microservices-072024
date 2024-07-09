package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;

//@Component
@Profile({"dev","prod"})
public class FinderRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(repository.findById(100).getName());

	}

}
