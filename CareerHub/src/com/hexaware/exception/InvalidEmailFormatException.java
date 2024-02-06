package com.hexaware.exception;

public class InvalidEmailFormatException extends Exception {

	public InvalidEmailFormatException() {
		
		
	}	
public InvalidEmailFormatException(String message) {
	super(message);
  System.out.println(message);		
		
	}	
	
	@Override
	public String toString() {
		return "InvalidEmailFormatException []";
	}

	


}
