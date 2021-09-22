package com.lasilveira.passwordvalidationapi.model;

public class RuleValidatorChainBuilder {

    private ChainableRuleValidator headValidator = null;
    
    public static RuleValidatorChainBuilder builder() {
        return new RuleValidatorChainBuilder();
    }
    
    public ChainableRuleValidator build() {
        return headValidator;
    }

    public RuleValidatorChainBuilder withMinLength(int minLength) {
        headValidator = new MinLengthValidator(minLength, headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withNoBlankSpace() {
        headValidator = new NoBlankSpaceValidator(headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withNoRepeatedCharacters() {
        headValidator = new NoRepeatedCharactersValidator(headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withAtLeastOneDigit() {
        headValidator = new AtLeastOneDigitValidator(headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withAtLeastOneLowerCase() {
        headValidator = new AtLeastOneLowerCaseValidator(headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withAtLeastOneSpecialChar() {
        headValidator = new AtLeastOneSpecialCharValidator(headValidator);
        return this;
    }
    
    public RuleValidatorChainBuilder withAtLeastOneUpperCase() {
        headValidator = new AtLeastOneUpperCaseValidator(headValidator);
        return this;
    }
}
