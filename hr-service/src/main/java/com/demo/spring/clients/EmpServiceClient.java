package com.demo.spring.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="emp-data-service")
public interface EmpServiceClient {

	@GetMapping(path="/emp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllEmps();
}
