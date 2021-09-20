package com.lasilveira.passwordvalidationapi.controller;

public class PasswordValidationResponse {

	@SuppressWarnings("unused")
	private boolean isValid;
	
	public PasswordValidationResponse(boolean isValid) {
		System.out.println(isValid);
		this.isValid = isValid;
	}

}
