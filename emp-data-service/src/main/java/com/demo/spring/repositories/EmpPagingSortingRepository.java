package com.demo.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.spring.entity.Emp;

public interface EmpPagingSortingRepository extends PagingAndSortingRepository<Emp, Integer> {

}
