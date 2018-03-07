package com.example.validatordemo.validation.validator;

import com.example.validatordemo.validation.LocalDateInTheFutureOrNow;
import com.example.validatordemo.validation.LocalDateInThePastOrNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateInThePastOrNowValidator implements ConstraintValidator<LocalDateInThePastOrNow, LocalDate> {
    @Override
    public void initialize(LocalDateInThePastOrNow localDateInThePastOrNow) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return null != localDate &&
                (localDate.isBefore(LocalDate.now()) || localDate.isEqual(LocalDate.now()));
    }
}