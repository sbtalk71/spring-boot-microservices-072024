package com.demo.spring.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

public class ClientWithSecurity {

	public static void main(String[] args) {
		String base_url = "http://localhost:8080/emp";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> respEnt = rt.getForEntity(base_url + "/104", String.class);

		System.out.println(respEnt.getBody());
		
		String respEnt1 = rt.getForObject(base_url + "/104", String.class);

		
		
		
		// Spring 6.1
		RestClient rc = RestClient.create(base_url);
		String resp = rc.get().uri("/106").accept(MediaType.APPLICATION_JSON).retrieve().body(String.class);

		System.out.println(resp);

		// *****
		Emp e = rc.get().uri("/107").accept(MediaType.APPLICATION_JSON).retrieve().body(Emp.class);

		System.out.println(e);

		// ***

		List<Emp> empList = rc.get().accept(MediaType.APPLICATION_JSON).retrieve()
				.body(new ParameterizedTypeReference<List<Emp>>() {
				});

		for (Emp emp : empList) {
			System.out.println(emp);
		}
	/*	
	String postResponse =	rc.post()
							.body(new Emp(125, "Kiran", "Bhopal", 46000))
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON)
							.retrieve()
							.body(String.class);
	
	System.out.println(postResponse);
	*/
	
	
	String delResponse =	rc.delete()
							.uri("/124")
							.accept(MediaType.TEXT_PLAIN)
							.retrieve()
							.body(String.class);

System.out.println(delResponse);
	

	}

}
