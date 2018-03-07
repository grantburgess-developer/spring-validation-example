package com.example.validatordemo.validation.validator;

import com.example.validatordemo.validation.LocalDateInTheFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateInTheFutureValidator implements ConstraintValidator<LocalDateInTheFuture, LocalDate> {
    @Override
    public void initialize(LocalDateInTheFuture localDateInTheFuture) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return null != localDate && localDate.isAfter(LocalDate.now());
    }
}