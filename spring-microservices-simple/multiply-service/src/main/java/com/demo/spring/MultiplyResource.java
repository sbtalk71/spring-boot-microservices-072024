package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplyResource {

	@GetMapping(path="/multiply/{a}/{b}",produces = "text/plain")
	public String addNums(@PathVariable("a") int a, @PathVariable("b") int b) {
		return (a*b)+"";
	}
}
