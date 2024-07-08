package com.demo.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpDao;

@Service
public class EmpService {

	@Autowired
	@Qualifier("dao2")
	private EmpDao dao;
	
	public String addEmp(int id, String name, String city, double salary) {
		String response=dao.save(new Emp(id, name, city, salary));
		return response;
	}
}
