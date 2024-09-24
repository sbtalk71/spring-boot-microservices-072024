package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.clients.EmpServiceClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/hr")
public class HrResource {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	EmpServiceClient empCLient;

	@CircuitBreaker(name="hr-service-config", fallbackMethod = "fallbackgetEmDetails")
	@GetMapping(path = "/emp/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed("emp.time") //emp_time
	@Counted("emp.count")//emp_count
	public ResponseEntity<String> getEmDetails(@PathVariable("empid") String empId) {
		return rt.getForEntity("http://emp-data-service/emp/" + empId, String.class);
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed("emp.list.time") //emp_time
	@Counted("emp.list.count")//emp_count
	public ResponseEntity<String> getAllEmpsData(){
		return empCLient.getAllEmps();
		
	}
	
	public ResponseEntity<String> fallbackgetEmDetails(Throwable t){
		return ResponseEntity.ok("Backend Service Unavailable..."+t.getMessage());
	}
}
