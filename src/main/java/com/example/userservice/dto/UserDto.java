package com.example.userservice.dto;


import com.example.userservice.vo.ResponseOrders;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    private String name;
    private String userEmail;
    private String pwd;
    private String userId;
    private LocalDate createdAt;

    private String encryptedPwd;
    private List<ResponseOrders>  orders;
}
