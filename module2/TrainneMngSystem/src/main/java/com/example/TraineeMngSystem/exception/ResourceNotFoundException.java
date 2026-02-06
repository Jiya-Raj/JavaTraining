package com.example.TraineeMngSystem.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3798063230883547894L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
