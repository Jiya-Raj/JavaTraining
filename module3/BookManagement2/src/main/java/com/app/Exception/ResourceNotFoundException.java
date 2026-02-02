package com.app.Exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3810793578644411148L;

	public ResourceNotFoundException(String mssg) {
		super(mssg);
	}
}
