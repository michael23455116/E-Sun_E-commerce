package com.michaelliu.esun.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRegisterRequest {
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
}
