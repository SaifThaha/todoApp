package com.example.todoapp.controllers;

import com.example.todoapp.dto.LoginForm;
import com.example.todoapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String AuthenticateUser(@RequestBody LoginForm loginForm){
        return authService.AuthenticateUser(loginForm);
    }
}
