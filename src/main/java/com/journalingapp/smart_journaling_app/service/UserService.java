package com.journalingapp.smart_journaling_app.service;

import com.journalingapp.smart_journaling_app.dto.UserRegistrationRequest;
import com.journalingapp.smart_journaling_app.dto.UserResponse;
import com.journalingapp.smart_journaling_app.model.User;
import com.journalingapp.smart_journaling_app.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(UserRegistrationRequest request) {
        // cek duplikat email
        userRepository.findByEmail(request.getEmail())
                .ifPresent(u -> { throw new RuntimeException("Email sudah dipakai!"); });

        // cek duplikat username
        userRepository.findByUsername(request.getUsername())
                .ifPresent(u -> { throw new RuntimeException("Username sudah dipakai!"); });

        User user = User.builder()
                .id(UUID.randomUUID())
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId().toString())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();
    }
}
