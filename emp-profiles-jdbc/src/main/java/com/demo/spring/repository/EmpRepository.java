package com.demo.spring.repository;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpRepository {

	public String save(Emp e);
	public Emp findById(int id) ;
	public List<Emp> findAllEmps();
	
	public int addMany(List<Emp> empList);
	public int addManyWIthTx(List<Emp> empList);
}
