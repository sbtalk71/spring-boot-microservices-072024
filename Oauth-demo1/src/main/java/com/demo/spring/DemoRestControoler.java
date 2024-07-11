package com.demo.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestControoler {
	@RequestMapping(path="/user/demo")
public String getGreeting() {
	return "You did it ";
}
}
