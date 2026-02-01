package com.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.util.MessageFormatter;

@Service
public class WelcomeService {
	private MessageFormatter formatter;

	@Value("${app.author")
	private String author;

	public WelcomeService(MessageFormatter formatter) {
		this.formatter = formatter;
	}

	public String greet(String name) {
		String message = "Welcome " + name + " to Spring Boot! by: " + author;
		return formatter.format(message);
	}
}
