package com.example.validatordemo.domain;

import com.example.validatordemo.validation.LocalDateInTheFutureOrNow;
import com.example.validatordemo.validation.LocalDateInThePastOrNow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    @NotNull(groups = ExistingValidationGroup.class)
    @Null(groups = NewValidationGroup.class)
    private Long id;

    @NotNull(
            message = "Name is required",
            groups = {ExistingValidationGroup.class, NewValidationGroup.class}
    )
    private String name;

    @NotNull(
            message = "Start date is required",
            groups = {ExistingValidationGroup.class, NewValidationGroup.class})
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @LocalDateInThePastOrNow(
            message = "Start date should be in the past or now",
            groups = {ExistingValidationGroup.class, NewValidationGroup.class}
    )
    private LocalDate startDate;

    @NotNull(
            message = "End date is required",
            groups = {ExistingValidationGroup.class, NewValidationGroup.class})
    @LocalDateInTheFutureOrNow(
            message = "End date should be in the future or now",
            groups = {ExistingValidationGroup.class, NewValidationGroup.class})
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
}