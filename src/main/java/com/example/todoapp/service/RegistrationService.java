package com.example.todoapp.service;

import com.example.todoapp.dto.RegistrationRequestDto;
import com.example.todoapp.dto.RegistrationResponseDto;

public interface RegistrationService {
    RegistrationResponseDto registerUser(RegistrationRequestDto requestDto);
}
