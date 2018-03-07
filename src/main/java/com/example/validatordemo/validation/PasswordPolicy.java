package com.example.validatordemo.validation;

import com.example.validatordemo.validation.validator.PasswordPolicyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { PasswordPolicyValidator.class })
public @interface PasswordPolicy {
    String message() default "Input does not match the regex pattern";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Pattern[] patterns();
}