package com.example.validatordemo.controller;

import com.example.validatordemo.domain.Campaign;
import com.example.validatordemo.domain.ExistingValidationGroup;
import com.example.validatordemo.domain.NewValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @GetMapping("")
    public ResponseEntity<?> getCampaigns() {
        return ResponseEntity.ok(
                Arrays.asList(
                    Campaign.builder().id(1L).build(),
                    Campaign.builder().id(2L).build()
                )
        );
    }

    @PostMapping("")
    public ResponseEntity<?> createCampaign(@Validated(NewValidationGroup.class) @RequestBody Campaign campaign) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<?> updateCampaign(@Validated(ExistingValidationGroup.class) @RequestBody Campaign campaign) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {
        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse.builder().message(errorMsg).build();
    }
}