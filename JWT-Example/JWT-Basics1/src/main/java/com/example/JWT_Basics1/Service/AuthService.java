package com.example.JWT_Basics1.Service;

import com.example.JWT_Basics1.DTO.RequestDetailsDTO;
import com.example.JWT_Basics1.DTO.LoginResponseDTO;
import com.example.JWT_Basics1.Entity.User;
import com.example.JWT_Basics1.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    AuthenticationManager authenticationmanager;
    @Autowired
    AuthUtil authUtil;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(RequestDetailsDTO requestDetailsDTO)
    {
        User user = userRepository.findByUsername(requestDetailsDTO.getUsername())

                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(requestDetailsDTO.getPassword(), user.getPassword()))
        {
            throw new RuntimeException("Invalid credentials");
        }
        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDTO(token);
    }

    public void signup(RequestDetailsDTO requestDetailsDTO)
    {
        if (userRepository.findByUsername(requestDetailsDTO.getUsername()).isPresent())
        {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();

        user.setUsername(requestDetailsDTO.getUsername());

        user.setPassword(passwordEncoder.encode(requestDetailsDTO.getPassword()));

        userRepository.save(user);








        //passwordEncoder i hv configured in securityConfig file as BcryptEncoder
//        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);
//        if(user != null) {
//            throw new IllegalArgumentException("User already present");
//        }
//        user = userRepository.save(User.builder().username(signupRequestDto.getUsername())
//                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
//                .build());
    }







    }

