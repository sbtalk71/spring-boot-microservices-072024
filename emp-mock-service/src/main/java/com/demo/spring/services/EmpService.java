package com.demo.spring.services;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpDao;

public class EmpService {

	private EmpDao dao;
	
	public String addEmp(int id, String name, String city, double salary) {
		String response=dao.save(new Emp(id, name, city, salary));
		return response;
	}
}
