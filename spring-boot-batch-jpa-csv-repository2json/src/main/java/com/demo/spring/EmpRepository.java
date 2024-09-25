package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
