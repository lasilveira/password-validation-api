package com.lasilveira.passwordvalidationapi.service;

import org.springframework.stereotype.Service;

import com.lasilveira.passwordvalidationapi.controller.PasswordValidationRequest;
import com.lasilveira.passwordvalidationapi.model.*;

@Service
public class PasswordValidationService {
	
	private RuleValidator passwordValidator;
	
	public PasswordValidationService() {
		passwordValidator =	new NoBlankSpaceValidator(
							new MinLengthValidator(9,
							new AtLeastOneDigitValidator(
							new AtLeastOneLowerCaseValidator(
							new AtLeastOneUpperCaseValidator(
							new AtLeastOneSpecialCharValidator(
							new NoRepeatedCharactersValidator()))))));
	}
	
	public boolean validatePassword(PasswordValidationRequest request) {
		String password = request.getPassword();
		return passwordValidator.validate(password);
		
//		if (password.equals("pass"))
//			return true;
//		else
//			return false;
	}

}
