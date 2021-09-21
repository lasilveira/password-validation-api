package com.lasilveira.passwordvalidationapi.ut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lasilveira.passwordvalidationapi.model.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleValidatorTests {

    //AtLeastOneDigitValidator
    @Test
    public void shouldReturnValidWhenHasAtLeastOneDigit() {
        RuleValidator validator = new AtLeastOneDigitValidator();
        assertTrue(validator.validate("abc123"));
        assertTrue(validator.validate("2"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasNoDigit() {
        RuleValidator validator = new AtLeastOneDigitValidator();        
        assertFalse(validator.validate("abcdef"));
    }
  
    //AtLeastOneLowerCaseValidator
    @Test
    public void shouldReturnValidWhenHasAtLeastOneLowercase() {
        RuleValidator validator = new AtLeastOneLowerCaseValidator();
        assertTrue(validator.validate("acbde"));
        assertTrue(validator.validate("ABCd"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasNoLowercase() {
        RuleValidator validator = new AtLeastOneLowerCaseValidator();        
        assertFalse(validator.validate("ABC123"));
    }
    
    //AtLeastOneSpecialCharValidator
    @Test
    public void shouldReturnValidWhenHasAtLeastOneSpecialChar() {
        RuleValidator validator = new AtLeastOneSpecialCharValidator();
        assertTrue(validator.validate("@"));
        assertTrue(validator.validate("123&abc*"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasNoSpecialChar() {
        RuleValidator validator = new AtLeastOneSpecialCharValidator();        
        assertFalse(validator.validate("abcABC123"));
    }
    
    //AtLeastOneUpperCaseValidator
    @Test
    public void shouldReturnValidWhenHasAtLeastOneUppercase() {
        RuleValidator validator = new AtLeastOneUpperCaseValidator();
        assertTrue(validator.validate("Abcd"));
        assertTrue(validator.validate("123456ABC"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasNoUppercase() {
        RuleValidator validator = new AtLeastOneUpperCaseValidator();        
        assertFalse(validator.validate("abc123$%&"));
    }
    
    //MinLengthValidator
    @Test
    public void shouldReturnValidWhenHasAtLeastNineChars() {
        RuleValidator validator = new MinLengthValidator(9);
        assertTrue(validator.validate("123456789"));
        assertTrue(validator.validate("abcdefghijklmnopqrstuv"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasLessThanNineChars() {
        RuleValidator validator = new MinLengthValidator(9);        
        assertFalse(validator.validate("12345678"));
    }
    
    //NoBlankSpaceValidator
    @Test
    public void shouldReturnValidWhenHasNoBlankSpace() {
        RuleValidator validator = new NoBlankSpaceValidator();
        assertTrue(validator.validate("abc"));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasBlankSpace() {
        RuleValidator validator = new NoBlankSpaceValidator();        
        assertFalse(validator.validate("abc def"));
        assertFalse(validator.validate(" abcdef"));
        assertFalse(validator.validate("abcdef "));
    }
    
    //NoRepeatedCharactersValidator
    @Test
    public void shouldReturnValidWhenHasNoRepeatedChars() {
        RuleValidator validator = new NoRepeatedCharactersValidator();
        assertTrue(validator.validate("abcABC"));
        assertTrue(validator.validate("b"));
        assertTrue(validator.validate(""));
    }
    
    @Test
    public void shouldReturnInvalidWhenHasRepeatedChars() {
        RuleValidator validator = new NoRepeatedCharactersValidator();        
        assertFalse(validator.validate("abcdefa"));
    }
    
}
