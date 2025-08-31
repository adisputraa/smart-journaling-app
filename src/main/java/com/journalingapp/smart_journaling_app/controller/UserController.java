package com.journalingapp.smart_journaling_app.controller;

import com.journalingapp.smart_journaling_app.dto.UserRegistrationRequest;
import com.journalingapp.smart_journaling_app.dto.UserResponse;
import com.journalingapp.smart_journaling_app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegistrationRequest request) {
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
