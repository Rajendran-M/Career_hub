package com.hexaware.exception;

public class FileUploadException extends Exception{

	public FileUploadException() {
		
	}

	public FileUploadException(String message) {
        System.out.println(message);
	}
	@Override
	public String toString() {
		return "FileUploadException []";
	}

}
