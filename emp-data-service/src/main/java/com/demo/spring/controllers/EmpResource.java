package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpService;
import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.util.ResponseData;

@RestController
@RequestMapping("/emp")
public class EmpResource {

	@Autowired
	private EmpService empService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Emp>> getAllEmps() {
		return ResponseEntity.ok(empService.listAll());
	}

	@GetMapping(path = "/{empid}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findById(@PathVariable("empid") int id) {
		Emp e = null;
		try {
			e = empService.findOneByIdAlt(id);

		} catch (EmpNotFoundException ex) {
			throw new RuntimeException(ex);
		}

		return ResponseEntity.ok(e);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity addEmp(@RequestBody Emp e) {
		Emp emp = null;
		try {
			emp=empService.save(e);
		} catch (EmpExistsException e2) {
			throw new RuntimeException(e2);
		}
		return ResponseEntity.ok(emp);
	}
	
	//Implement DELETE and PUT (Update)

	// Exception Handlers
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ResponseData> handleRuntimeException(RuntimeException ex) {
		return ResponseEntity.ok(new ResponseData(ex.getMessage()));
	}
}
