package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	
}
