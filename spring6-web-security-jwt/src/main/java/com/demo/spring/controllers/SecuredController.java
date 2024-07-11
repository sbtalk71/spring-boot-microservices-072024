package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.AuthRequest;
import com.demo.spring.jwt.util.JwtUtil;

@RestController
public class SecuredController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtUtil jwtUtil;

	@GetMapping("/user")
	public String user() {
		return "User Role login success";
	}

	@GetMapping("/info")
	public String info() {
		return "All Can access this page";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Admin Page loaded";
	}

	@PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
		System.out.println(authRequest.getUsername());
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid Credentials..");
		}

		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
