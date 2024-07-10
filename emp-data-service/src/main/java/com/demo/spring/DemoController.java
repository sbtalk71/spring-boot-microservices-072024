package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class DemoController {

	//GET http://localhost:8080/greet
	//@RequestMapping(path="/greet",method = RequestMethod.GET)
	@GetMapping(path="/greet")
	//@ResponseBody
	public String greet() {
		return "Hello from MVC";
	}
}
