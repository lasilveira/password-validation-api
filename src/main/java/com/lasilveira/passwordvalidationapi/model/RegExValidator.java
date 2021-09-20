package com.lasilveira.passwordvalidationapi.model;

public abstract class RegExValidator extends PasswordRuleValidator {

	protected String regEx;
	
	public RegExValidator(String regEx, RuleValidator nextRule) {
		super(nextRule);
		this.regEx = regEx;
	}

	@Override
	protected boolean doValidate(String password) {
		try {			
			return password.matches(regEx);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
