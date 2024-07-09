package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;

//@Component
@Profile("dev")
public class InsertRunner implements CommandLineRunner {

	@Autowired
	EmpRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println(repository.save(new Emp(100,"Shantanu","Hyderabad",20000)));
		
		List<Emp> empList=new ArrayList<>();
		empList.add(new Emp(108, "Raju", "Hyderabad", 45000));
		empList.add(new Emp(109, "Kiran", "Bangalore", 45000));
		empList.add(new Emp(110, "Shruthi", "Hyderabad", 75000));
		
		System.out.println(repository.addMany(empList));
		
		System.out.println(repository.getClass().getName());

	}

}
