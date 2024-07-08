package com.demo;

public class App {

	public static void main(String[] args) {
		
		
		Message m1=new Message("Good Morning");
		
		Greeter g1=new Greeter(m1);
		
		
		Greeter g2=new Greeter();
		g2.setMessage(m1);
		
		System.out.println(g1.getMessage());
	}

}
