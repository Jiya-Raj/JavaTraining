package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class HelloController {

	@GetMapping(path = "welcome")
	public String hello(@RequestParam(name = "name") String userName,
			@RequestParam(name = "city") String address
			) {
		return "hello " + userName+" from "+address;
	}
}
