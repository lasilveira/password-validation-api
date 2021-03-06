package com.lasilveira.passwordvalidationapi.controller;

public class PasswordValidationRequest {

    private String password;
    
	public PasswordValidationRequest(String password) {
        this.password = password;
    }
	
   public PasswordValidationRequest() {
       
    }

	@Override
	public String toString() {
		return "PasswordValidationRequest [password=" + password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
