package com.example.todoapp.dto;

import com.example.todoapp.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
