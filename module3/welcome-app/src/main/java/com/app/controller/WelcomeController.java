package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.GreetingService;
import com.app.service.WelcomeService;

@RestController
@RequestMapping("/api")
public class WelcomeController {

	private final WelcomeService welcomeService;
	// private final GreetingService greetingService;

	public WelcomeController(WelcomeService service) {
		this.welcomeService = service;
		// this.greetingService=greetingService;
	}

	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable String name) {
		return welcomeService.greet(name);
	}

	@GetMapping("/welcome/health")
	public Map<String, String> health() {
		Map<String, String> response = new HashMap<>();
		response.put("status", "UP");
		response.put("application", "welcome-app");
		return response;
	}

}
