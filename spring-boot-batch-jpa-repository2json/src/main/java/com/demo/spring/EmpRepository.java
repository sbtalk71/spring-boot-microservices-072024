package com.demo.spring;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer> {

}
