package com.app.service;

import org.springframework.stereotype.Service;

@Service("Evening")
public class GreetingImpl implements GreetingService {

	@Override
	public String greet(String name) {

		return "Evening";
	}

}
