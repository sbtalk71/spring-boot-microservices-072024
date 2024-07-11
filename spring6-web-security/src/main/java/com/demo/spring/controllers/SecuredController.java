package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
	
	@GetMapping("/user")
	public String user() {
		return "User Role login success";
	}
	
	@GetMapping("/info")
	public String info() {
		return "All Can access this page";
	}

}
