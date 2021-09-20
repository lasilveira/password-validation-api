package com.lasilveira.passwordvalidationapi.model;

public class AtLeastOneLowerCaseValidator extends AtLeastOneOfValidator {

	private static final String LOWERCASE = "a-z";
	
	public AtLeastOneLowerCaseValidator(RuleValidator nextRule) {
		super(LOWERCASE, nextRule);
	}
	
	public AtLeastOneLowerCaseValidator() {
		super(LOWERCASE, null);
	}

}
