package com.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository("msg")
public class Message {

	private String greetings="Hello There!";

	public Message() {
		System.out.println("Message Bean Created..");
	}

	public Message(String greetings) {
		this.greetings = greetings;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

}
