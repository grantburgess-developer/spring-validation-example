package com.example.validatordemo.validation.validator;

import com.example.validatordemo.validation.PasswordPolicy;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PasswordPolicyValidator implements ConstraintValidator<PasswordPolicy, String> {
    private Map<java.util.regex.Pattern, String> patterns;

    @Override
    public void initialize(PasswordPolicy passwordPolicy) {
        patterns = Arrays.stream(passwordPolicy.patterns())
                .collect(
                        Collectors.toMap(
                                PasswordPolicyValidator::apply,
                                Pattern::message)
                );
    }

    private static java.util.regex.Pattern apply(Pattern x) {
        return java.util.regex.Pattern.compile(x.regexp(), 0);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean hasError = false;

        for (Map.Entry<java.util.regex.Pattern, String> pattern : patterns.entrySet()) {
            if (!pattern.getKey().matcher(password).matches()) {
                hasError = true;
                constraintValidatorContext
                        .buildConstraintViolationWithTemplate(pattern.getValue())
                        .addConstraintViolation();
            }
        }

        return !hasError;
    }
}