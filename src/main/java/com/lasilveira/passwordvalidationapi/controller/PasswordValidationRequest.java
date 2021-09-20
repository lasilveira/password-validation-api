package com.lasilveira.passwordvalidationapi.controller;

public class PasswordValidationRequest {

	@Override
	public String toString() {
		return "PasswordValidationRequest [password=" + password + "]";
	}

	private String password;

	public String getPassword() {
		return password;
	}
}
