package com.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Modifying
	@Transactional
	//@Query("update Emp e set e.salary=e.salary+:amount where e.empId=:id")
	@Query(value="update emp e set e.salary=e.salary+?2 where e.empno=?1", nativeQuery = true)
	public int addBonus(Integer id,double amount);
	
	
}
