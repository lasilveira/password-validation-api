package com.lasilveira.passwordvalidationapi.ut;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.lasilveira.passwordvalidationapi.service.PasswordValidationService;
import com.lasilveira.passwordvalidationapi.controller.PasswordValidationRequest;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidationServiceTests {

    @InjectMocks
    private PasswordValidationService validationService;

    @Test
    public void shouldReturnValidPassword() {
        assertTrue(validationService.validatePassword(new PasswordValidationRequest("AbTp9!fok")).isValid());
        assertTrue(validationService.validatePassword(new PasswordValidationRequest("ABCdefGHI123@")).isValid());
    }
    
    @Test
    public void shouldReturnInvalidPassword() {
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("abc ")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("12345678")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("abcdefghi")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("abcdefg123")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("ABCDEFGHI123")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("ABCdefGHI123")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("ABCdeffGHI123@")).isValid());
        
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("aa")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("ab")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("AAAbbbCc")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("AbTp9!foo")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("AbTp9!foA")).isValid());
        assertFalse(validationService.validatePassword(new PasswordValidationRequest("AbTp9 fok")).isValid());
    }

}
