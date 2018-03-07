package com.example.validatordemo.domain;

import com.example.validatordemo.validation.ComparePasswordToConfirmPassword;
import com.example.validatordemo.validation.PasswordPolicy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ComparePasswordToConfirmPassword(
        groups = { ExistingValidationGroup.class, NewValidationGroup.class }
)
public class User {
    @NotNull(groups = ExistingValidationGroup.class)
    @Null(groups = NewValidationGroup.class)
    private Long id;

    @NotNull(
            message = "Username is required",
            groups = { ExistingValidationGroup.class, NewValidationGroup.class }
    )
    private String username;

    @NotNull(
            message = "Password is required",
            groups = { ExistingValidationGroup.class, NewValidationGroup.class }
    )
    @PasswordPolicy(patterns = {
            @Pattern(regexp = ".*?[a-zA-Z](.*)",      message = "Password does not contain a letter",            groups = { ExistingValidationGroup.class, NewValidationGroup.class }),
            @Pattern(regexp = "(.*)\\d(.*)",          message = "Password does not contain a digit",             groups = { ExistingValidationGroup.class, NewValidationGroup.class }),
            @Pattern(regexp = "(.*)[^a-zA-Z0-9](.*)", message = "Password does not contain a symbol",            groups = { ExistingValidationGroup.class, NewValidationGroup.class }),
            @Pattern(regexp = "(.*)[a-z](.*)",        message = "Password does not contain a lowercase letter",  groups = { ExistingValidationGroup.class, NewValidationGroup.class }),
            @Pattern(regexp = "(.*)[A-Z](.*)",        message = "Password does not contain an uppercase letter", groups = { ExistingValidationGroup.class, NewValidationGroup.class })
        },
        groups = { ExistingValidationGroup.class, NewValidationGroup.class }
    )
    @Size.List({
            @Size(min = 6,  message = "should contain at least {min} characters;", groups = { ExistingValidationGroup.class, NewValidationGroup.class }),
            @Size(max = 20, message = "should be less than {max} characters;",     groups = { ExistingValidationGroup.class, NewValidationGroup.class })
        }
    )
    private String password;

    @NotNull(
            message = "Confirm Password is required",
            groups = { ExistingValidationGroup.class, NewValidationGroup.class }
    )
    private String confirmPassword;
}