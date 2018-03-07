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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
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