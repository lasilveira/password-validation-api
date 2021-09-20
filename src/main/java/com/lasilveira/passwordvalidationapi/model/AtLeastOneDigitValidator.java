package com.lasilveira.passwordvalidationapi.model;

public class AtLeastOneDigitValidator extends AtLeastOneOfValidator {

	private static final String DIGIT = "\\d";
	
	public AtLeastOneDigitValidator(RuleValidator nextRule) {
		super(DIGIT, nextRule);
	}
	
	public AtLeastOneDigitValidator() {
		super(DIGIT, null);
	}

}
