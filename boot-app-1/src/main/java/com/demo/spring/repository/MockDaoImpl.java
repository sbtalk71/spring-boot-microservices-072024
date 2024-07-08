package com.demo.spring.repository;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class MockDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "Emp with id "+e.getEmpId()+" is saved";
	}

}
