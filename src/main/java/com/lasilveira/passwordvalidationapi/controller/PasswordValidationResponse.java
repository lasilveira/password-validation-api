package com.lasilveira.passwordvalidationapi.controller;

public class PasswordValidationResponse {

	private boolean valid;

	public PasswordValidationResponse(boolean valid) {
		this.valid = valid;
	}
	
	@Override
	public String toString() {
		return "PasswordValidationResponse [valid=" + valid + "]";
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}


	
}
