package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.entity.EmpNotFoundException;
import com.demo.spring.jwt.util.JwtUtil;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.AuthRequest;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {
	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	EmpRepository empRepository;

	// find/100-->empId=100
	// @RequestMapping(path = "/find/{empId}", method = RequestMethod.GET)
	@GetMapping(path = "/find/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity findOneEmp(@PathVariable("empId") int id) {
		System.out.println(empRepository.getClass().getName());
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			throw new EmpNotFoundException();
		}
	}

	@PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody Emp e) {
		if (empRepository.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("Emp already exists"));
		} else {
			empRepository.save(e);
			return ResponseEntity.ok(new Message("Emp saved"));
		}
	}

	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {
		List<Emp> empList = empRepository.findAll();
		return ResponseEntity.ok(empList);
	}

	@PatchMapping(path = "/update/{empId}/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateSalary(@PathVariable("empId") int id, @PathVariable("salary") double sal) {

		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			empRepository.updateSalary(id, sal);
			return ResponseEntity.ok(new Message("Salary Updated"));
		} else {
			return ResponseEntity.ok(new Message("Emp Does not exist"));
		}
	}

	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<Message> handleEmpNotFound(EmpNotFoundException ex) {
		return ResponseEntity.ok(new Message("Emp not found.."));
	}

	@PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid Credentials..");
		}

		return jwtUtil.generateToken(authRequest.getUserName());
	}
}
