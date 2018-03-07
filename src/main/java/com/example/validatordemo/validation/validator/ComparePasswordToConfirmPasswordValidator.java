package com.example.validatordemo.validation.validator;

import com.example.validatordemo.domain.User;
import com.example.validatordemo.validation.ComparePasswordToConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ComparePasswordToConfirmPasswordValidator implements ConstraintValidator<ComparePasswordToConfirmPassword, User> {
    @Override
    public void initialize(ComparePasswordToConfirmPassword comparePasswordToConfirmPassword) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if (user == null || user.getPassword() == null || user.getConfirmPassword() == null) {
            return true;
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(
                            constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("password")
                    .addConstraintViolation();

            return false;
        }

        return true;
    }
}