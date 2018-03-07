package com.example.validatordemo.validation;

import com.example.validatordemo.validation.validator.LocalDateInThePastValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { LocalDateInThePastValidator.class })
public @interface LocalDateInThePast {
    String message() default "Date must be less than the current date";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
        }