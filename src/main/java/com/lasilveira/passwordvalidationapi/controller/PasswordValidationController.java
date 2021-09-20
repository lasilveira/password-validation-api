package com.lasilveira.passwordvalidationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lasilveira.passwordvalidationapi.service.PasswordValidationService;

@RestController
@RequestMapping("/api/v1")
public class PasswordValidationController implements PasswordValidationAPI{

	@Autowired
	private PasswordValidationService validationService;

	@Override
	@PostMapping(
			value = "/password",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PasswordValidationResponse validatePassword(@RequestBody PasswordValidationRequest request) {
		System.out.println(request.toString());
		return validationService.validatePassword(request);
	}

}
