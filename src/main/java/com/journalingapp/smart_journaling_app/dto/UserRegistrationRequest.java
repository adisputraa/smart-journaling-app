package com.journalingapp.smart_journaling_app.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String username;
    private String email;
    private String password;
}
