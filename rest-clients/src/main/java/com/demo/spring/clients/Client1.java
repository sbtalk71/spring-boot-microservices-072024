package com.demo.spring.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client1 {

	public static void main(String[] args) {
		String base_url = "http://localhost:8080/user";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> respEnt = rt.getForEntity(base_url, String.class);

		System.out.println(respEnt.getBody());

		
		
	}

}
