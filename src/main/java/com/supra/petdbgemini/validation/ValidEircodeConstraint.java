package com.supra.petdbgemini.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEircode.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEircodeConstraint {
    String message() default "Invalid Eircode format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}