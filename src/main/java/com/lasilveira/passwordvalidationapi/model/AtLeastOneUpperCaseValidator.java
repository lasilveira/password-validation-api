package com.lasilveira.passwordvalidationapi.model;

public class AtLeastOneUpperCaseValidator extends AtLeastOneOfValidator {
	
	private static final String UPPERCASE = "A-Z";
	
	public AtLeastOneUpperCaseValidator(RuleValidator nextRule) {
		super(UPPERCASE, nextRule);
	}
	
	public AtLeastOneUpperCaseValidator() {
		super(UPPERCASE, null);
	}

}
