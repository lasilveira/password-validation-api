package com.lasilveira.passwordvalidationapi.service;

import org.springframework.stereotype.Service;

import com.lasilveira.passwordvalidationapi.controller.PasswordValidationRequest;

@Service
public class PasswordValidationService {
	
	public PasswordValidationService() {
		
	}
	
	public boolean validatePassword(PasswordValidationRequest request) {
		String password = request.getPassword();
		if (password.equals("pass"))
			return true;
		else
			return false;
	}

}
