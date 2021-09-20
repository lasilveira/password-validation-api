package com.lasilveira.passwordvalidationapi.model;

public class NoBlankSpaceValidator extends RegExValidator {

	private static final String NO_BLANK_SPACE = "^[^\s]*$";
	
	public NoBlankSpaceValidator(RuleValidator nextRule) {
		super(NO_BLANK_SPACE, nextRule);
	}
	
	public NoBlankSpaceValidator() {
		super(NO_BLANK_SPACE, null);
	}

}
