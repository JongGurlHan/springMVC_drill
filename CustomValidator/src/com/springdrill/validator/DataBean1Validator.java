package com.springdrill.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springdrill.beans.DataBean1;

public class DataBean1Validator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return DataBean1.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "data2", "error2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "error3");
		}
	
	

}
