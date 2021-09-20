package com.lasilveira.passwordvalidationapi.model;

public abstract class AtLeastOneOfValidator extends RegExValidator {
	
	public AtLeastOneOfValidator(String charSet, RuleValidator nextRule) {
		super(".*[" + charSet + "]+.*", nextRule);
	}

}
