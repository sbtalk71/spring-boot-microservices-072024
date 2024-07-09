package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;

@Component
@Profile("dev")
public class InsertRunnerWIthTx implements CommandLineRunner {

	@Autowired
	EmpRepository repository;

	@Autowired
	TransactionTemplate tt;

	@Override
	public void run(String... args) throws Exception {

		// System.out.println(repository.save(new
		// Emp(100,"Shantanu","Hyderabad",20000)));

		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(108, "Raju", "Hyderabad", 45000));
		empList.add(new Emp(109, "Kiran", "Bangalore", 45000));
		empList.add(new Emp(105, "Shruthi", "Hyderabad", 75000));

		int count=tt.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				int count = repository.addManyWIthTx(empList);
				return count;
			}
		});

		System.out.println("Rows Updated : "+count);

		System.out.println(repository.getClass().getName());

	}

}
