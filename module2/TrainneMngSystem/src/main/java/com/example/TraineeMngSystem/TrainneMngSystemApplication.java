package com.example.TraineeMngSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class TrainneMngSystemApplication implements CommandLineRunner {
	
	@Autowired
	private EntityManager emf;

	public static void main(String[] args) {
		SpringApplication.run(TrainneMngSystemApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		if(emf!=null) {
			System.out.println("emf is created");
		}
	}

}
