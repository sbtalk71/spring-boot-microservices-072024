package com.demo.spring.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.repositories.EmpPagingSortingRepository;

@RestController
public class EmpPageSortResource {

	@Autowired
	EmpPagingSortingRepository repository;
	
	@GetMapping(path="/data/{pgNo}/{size}")
	public ResponseEntity getPagedData(@PathVariable("pgNo") int pageNo, @PathVariable("size")int size) {
		Pageable pages=PageRequest.of(pageNo, size,Sort.by("name").descending());
		return ResponseEntity.ok(repository.findAll(pages).get().toList());
	}
}
