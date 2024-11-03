package com.example.todoapp.serviceImpl;

import com.example.todoapp.dto.LoginForm;
import com.example.todoapp.service.AuthService;
import com.example.todoapp.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    @Override
    public String AuthenticateUser(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.getEmail(),loginForm.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateJwtToken(userDetailsService.loadUserByUsername(loginForm.getEmail()));
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
