package com.example.validatordemo.validation;

import com.example.validatordemo.validation.validator.ComparePasswordToConfirmPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { ComparePasswordToConfirmPasswordValidator.class })
public @interface ComparePasswordToConfirmPassword {
    String message() default "Password and Confirm Password must be equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}