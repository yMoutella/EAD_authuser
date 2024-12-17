package com.ead.authuser.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameConstraintImpl implements ConstraintValidator<UsernameConstraint, String> {

    @Override 
    public void initialize(UsernameConstraint constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value.trim().isEmpty() || value.contains(" ")|| value == null){
            return false;
        }
        
        return true;
    }

}
