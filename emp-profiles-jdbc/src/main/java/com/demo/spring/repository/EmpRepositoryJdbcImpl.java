package com.demo.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpRepositoryJdbcImpl implements EmpRepository {

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

}
