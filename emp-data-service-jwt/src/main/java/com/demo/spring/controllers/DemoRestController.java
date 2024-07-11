package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	
	
	@RequestMapping(path="/info", method = RequestMethod.GET)
	public String info() {
		return "This is a REST Service";
	}
}
