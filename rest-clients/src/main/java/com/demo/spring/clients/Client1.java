package com.demo.spring.clients;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client1 {

	public static void main(String[] args) {
		String base_url = "http://localhost:8080/user";

		RestTemplate rt = new RestTemplate();

		String credentials="arun:welcome1";
		String encryptedCreds=Base64.getEncoder().encodeToString(credentials.getBytes());
		System.out.println(encryptedCreds);
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Authorization", "Basic "+encryptedCreds);
		
		HttpEntity requestData=new HttpEntity<>(headers);
		
		ResponseEntity<String> respEnt=rt.exchange(base_url, HttpMethod.GET, requestData, String.class);

		System.out.println(respEnt.getBody());
		
		
		
	}

}
