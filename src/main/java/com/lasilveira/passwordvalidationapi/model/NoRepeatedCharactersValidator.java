package com.lasilveira.passwordvalidationapi.model;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatedCharactersValidator extends PasswordRuleValidator {

	private Set<Character> characters;
	
	public NoRepeatedCharactersValidator(RuleValidator nextRule) {
		super(nextRule);
		initialize();
	}

	public NoRepeatedCharactersValidator() {
		super(null);
		initialize();
	}
	
	private void initialize() {
		this.characters = new HashSet<Character>();
	}

	@Override
	protected boolean doValidate(String password) {
		
		characters.clear();
		for(char c : password.toCharArray()) {
		    if (characters.contains(c))
		    	return false;
		    else
		    	characters.add(c);
		}
		return true;
	}

}
