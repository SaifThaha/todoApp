package com.example.todoapp.controllers;

import com.example.todoapp.dto.RegistrationRequestDto;
import com.example.todoapp.dto.RegistrationResponseDto;
import com.example.todoapp.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationResponseDto registerUser(@Valid @RequestBody RegistrationRequestDto requestDto){
        return registrationService.registerUser(requestDto);
    }
}
