package com.lasilveira.passwordvalidationapi.model;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatedCharactersValidator extends ChainableRuleValidator {
	
	public NoRepeatedCharactersValidator(RuleValidator nextRule) {
		super(nextRule);
	}

	public NoRepeatedCharactersValidator() {
		super(null);
	}

	@Override
	protected boolean doValidate(String password) {
		Set<Character> characters = new HashSet<Character>();
		for(char c : password.toCharArray()) {
		    if (characters.contains(c))
		    	return false;
		    else
		    	characters.add(c);
		}
		return true;
	}

}
