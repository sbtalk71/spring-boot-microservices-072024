package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hr")
public class HrResource {

	@Autowired
	RestTemplate rt;

	@GetMapping(path = "/emp/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getEmDetails(@PathVariable("empid") String empId) {
		return rt.getForEntity("http://emp-data-service/emp/" + empId, String.class);
	}
}
