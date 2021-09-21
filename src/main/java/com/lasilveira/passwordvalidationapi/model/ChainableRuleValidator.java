package com.lasilveira.passwordvalidationapi.model;

public abstract class ChainableRuleValidator implements RuleValidator {

	public ChainableRuleValidator(RuleValidator nextRule) {
		this.nextRule = nextRule;
	}
	
	private RuleValidator nextRule;
	
	@Override
	public boolean validate(String text) {
		
		if(!doValidate(text)) {
			return false;
		} else if(nextRule != null) {
			return nextRule.validate(text);
		} else
			return true;
		
	}
	
	protected abstract boolean doValidate(String password);

}
