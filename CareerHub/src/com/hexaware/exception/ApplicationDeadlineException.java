package com.hexaware.exception;

public class ApplicationDeadlineException extends Exception{

	public ApplicationDeadlineException() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationDeadlineException(String message) {
		super(message);
		System.out.println(message);
	}

	@Override
	public String toString() {
		return "ApplicationDeadlineException []";
	}
	
}
