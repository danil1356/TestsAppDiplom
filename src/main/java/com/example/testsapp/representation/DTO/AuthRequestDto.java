package com.example.testsapp.representation.DTO;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String login;
    private String password;
}
