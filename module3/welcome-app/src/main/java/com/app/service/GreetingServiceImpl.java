package com.app.service;

import org.springframework.stereotype.Service;

@Service("Morning")
public class GreetingServiceImpl implements GreetingService{

	@Override
	public String greet(String name) {
		return "Morning";
	}
	

}
