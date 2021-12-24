package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestLogin {

    @NotNull(message = "email cannot be null")
    @Size(min = 2, message = "email cannot be less then 2 char")
    @Email
    private String userEmail;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password cannot be less then 8 char")
    @Email
    private String password;
}
