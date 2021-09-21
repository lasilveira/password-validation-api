package com.lasilveira.passwordvalidationapi.model;

public class MinLengthValidator extends ChainableRuleValidator {

	private int minLength;
	
	public MinLengthValidator(int minLength, RuleValidator nextRule) {
		super(nextRule);
		this.minLength = minLength;
	}
	
	public MinLengthValidator(int minLength) {
		super(null);
		this.minLength = minLength;
	}

	@Override
	protected boolean doValidate(String password) {
		return (password.length() >= minLength);
	}

}
