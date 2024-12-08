package com.supra.petdbgemini.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Email
    @NotBlank
    private String username; // Email as username
    @NotBlank
    private String password;
    private String firstName;
    private String lastName;
    private String county;
}