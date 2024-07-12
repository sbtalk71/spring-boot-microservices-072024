package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorResource {

	@Autowired
	RestTemplate rt;

	@GetMapping(path = "/calculate/{a}/{b}", produces = "text/plain")
	public String addNums(@PathVariable("a") int a, @PathVariable("b") int b) {
		String product = rt.getForObject("http://multiply-service/multiply/" + a + "/" + b, String.class);
		String sum = rt.getForObject("http://add-service/add/" + a + "/" + b, String.class);

		String str = """
				{
				"sum":%s,
				"product":%s
				}
				""";
		return String.format(str, sum, product);
	}
}
