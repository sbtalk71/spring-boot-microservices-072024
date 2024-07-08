package com.demo.spring.repository;

import com.demo.spring.entity.Emp;


public class MockDaoImpl2 implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "DAO2:Emp with id "+e.getEmpId()+" is saved";
	}

}
