package com.example.todoapp.service;

import com.example.todoapp.dto.LoginForm;

public interface AuthService {
    String AuthenticateUser(LoginForm loginForm);
}
