package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/")
public class UsersController {

    private Environment env;
    private Greeting greeting;
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    public UsersController(Environment env, Greeting greeting, UserService userService) {
        this.env = env;
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping(value = "/health_check")
    public String status() {
        return String.format("It's working in user service on port %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
//        return greeting.getMessage();
    }

    @PostMapping("/users")
    @ApiOperation(value = "회원 등록", notes = "회원 정보를 받아 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원 등록 완료."),
            @ApiResponse(code = 404, message = "서버 문제 발생"),
            @ApiResponse(code = 500, message = "페이지를 찾을 수 없음")
    })
    public ResponseEntity<ResponseUser> createUser(@RequestBody @ApiParam(value = "회원 한 명의 정보를 가진 객체", required = true) RequestUser user) {

        UserDto userDto = objectMapper.convertValue(user, UserDto.class);
        userService.createUser(userDto);
        ResponseUser responseUser = objectMapper.convertValue(userDto, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userList = userService.getUserByAll();
        List<ResponseUser> result = new ArrayList<>();
        for (UserEntity user : userList) {
            result.add(objectMapper.convertValue(user, ResponseUser.class));
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId) {
        UserDto user = userService.getUserByUserId(userId);
        ResponseUser result = objectMapper.convertValue(user, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

//    @PostMapping("/login")
//    public ResponseEntity

}
