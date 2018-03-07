package com.example.validatordemo.validation.validator;

import com.example.validatordemo.validation.LocalDateInThePast;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateInThePastValidator implements ConstraintValidator<LocalDateInThePast, LocalDate> {
    @Override
    public void initialize(LocalDateInThePast localDateInThePast) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return null != localDate && localDate.isBefore(LocalDate.now());
    }
}