package com.example.todoapp.serviceImpl;

import com.example.todoapp.dto.RegistrationRequestDto;
import com.example.todoapp.dto.RegistrationResponseDto;
import com.example.todoapp.entities.User;
import com.example.todoapp.repositories.UserRepository;
import com.example.todoapp.service.RegistrationService;
import org.modelmapper.ModelMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegistrationResponseDto registerUser(RegistrationRequestDto requestDto) {
        User user = modelMapper.map(requestDto, User.class);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        User registeredUser = userRepository.save(user);

        return modelMapper.map(registeredUser,RegistrationResponseDto.class);
    }
}
