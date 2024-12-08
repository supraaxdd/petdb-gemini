package com.supra.petdbgemini.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEircode implements ConstraintValidator<ValidEircodeConstraint, String> {

    private static final String EIRCODE_PATTERN = "[A-WXY][0-9][A-Z0-9] [0-9][A-Z0-9][A-Z0-9]";

    @Override
    public boolean isValid(String eircode, ConstraintValidatorContext context) {
        if (eircode == null) {
            return false;
        }
        return eircode.matches(EIRCODE_PATTERN);
    }
}