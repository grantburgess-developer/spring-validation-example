package com.example.validatordemo.validation.validator;

import com.example.validatordemo.validation.LocalDateInTheFutureOrNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateInTheFutureOrNowValidator implements ConstraintValidator<LocalDateInTheFutureOrNow, LocalDate> {
    @Override
    public void initialize(LocalDateInTheFutureOrNow localDateInTheFutureOrNow) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return null != localDate &&
                (localDate.isAfter(LocalDate.now()) || localDate.isEqual(LocalDate.now()));
    }
}