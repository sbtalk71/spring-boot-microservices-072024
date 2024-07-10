package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.repositories.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;
	
}
