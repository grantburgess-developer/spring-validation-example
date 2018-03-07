package com.example.validatordemo.validation;

import com.example.validatordemo.validation.validator.LocalDateInThePastOrNowValidator;

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
@Constraint(validatedBy = { LocalDateInThePastOrNowValidator.class })
public @interface LocalDateInThePastOrNow {
    String message() default "Date must be less than or equal to the current date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}