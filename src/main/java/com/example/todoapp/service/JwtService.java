package com.example.todoapp.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateJwtToken(UserDetails userDetails);
    String extractUsername(String jwtToken);
    boolean isTokenValid(String jwtToken);
}
