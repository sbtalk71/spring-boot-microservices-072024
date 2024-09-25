package com.demo.spring;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpItemProcessor implements ItemProcessor<Integer, Emp>{

	@Autowired
	EmpRepository empRepository;
	
	@Override
	public Emp process(Integer id) throws Exception {
		Emp e=empRepository.findById(id).orElseThrow(()->new RuntimeException("Emp not found"));
		System.out.println("Processing : "+id);
		return e;
	}

}
