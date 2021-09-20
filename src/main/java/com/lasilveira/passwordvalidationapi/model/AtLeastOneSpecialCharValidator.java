package com.lasilveira.passwordvalidationapi.model;

public class AtLeastOneSpecialCharValidator extends AtLeastOneOfValidator {

	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";
	
	public AtLeastOneSpecialCharValidator(RuleValidator nextRule) {
		super(SPECIAL_CHARACTERS, nextRule);
	}
	
	public AtLeastOneSpecialCharValidator() {
		super(SPECIAL_CHARACTERS, null);
	}

}
