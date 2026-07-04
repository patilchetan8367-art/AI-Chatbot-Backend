package com.dto;

public class LoginResponse {
	
	
	String name;
	String email;
	String message;
	
	public LoginResponse() {
		super();
	}
	public LoginResponse(String message, String name, String email) {
	    this.message = message;
	    this.name = name;
	    this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
