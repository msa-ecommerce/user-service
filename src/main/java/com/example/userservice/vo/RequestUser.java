package com.example.userservice.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel(value = "회원정보", description = "이메일, 이름, 비밀번호 Class")
public class RequestUser {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters.")
    @Email
    private String userEmail;

    @NotNull(message = "name cannot be null")
    @Size(min = 2, message = "name not be less than two characters.")
    private String name;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password not be less than eight characters.")
    private String pwd;
}
