package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	//@Autowired //(as we are using AOP)
	//private Audience audience;

	@Override
	public void perform(String name,int age) throws PerformerExeption{
		//audience.takeSeat();
		//audience.switchOffMobiles();
		System.out.println(name+" is now Singing...");
		//audience.applaud();
		

	}

}
