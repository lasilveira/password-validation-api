package com.lasilveira.passwordvalidationapi.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lasilveira.passwordvalidationapi.controller.PasswordValidationRequest;
import com.lasilveira.passwordvalidationapi.controller.PasswordValidationResponse;
import com.lasilveira.passwordvalidationapi.model.*;

@Service
public class PasswordValidationService {
	
	private RuleValidator passwordValidator;
	private static final Logger logger = Logger.getLogger(PasswordValidationService.class);

	public PasswordValidationService() {
		passwordValidator =	new NoBlankSpaceValidator(
							new MinLengthValidator(9,
							new AtLeastOneDigitValidator(
							new AtLeastOneLowerCaseValidator(
							new AtLeastOneUpperCaseValidator(
							new AtLeastOneSpecialCharValidator(
							new NoRepeatedCharactersValidator()))))));
	}
	
	public PasswordValidationResponse validatePassword(PasswordValidationRequest request) {
		String password = request.getPassword();
		boolean result = passwordValidator.validate(password);
		logger.debug("Validate password: " + request.toString() + "; result=" + result);
		return new PasswordValidationResponse(result);
	}

}
