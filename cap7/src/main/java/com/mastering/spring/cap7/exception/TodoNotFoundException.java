package com.mastering.spring.cap7.exception;

public class TodoNotFoundException extends RuntimeException {

	
	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TodoNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return message; 
	}

}
