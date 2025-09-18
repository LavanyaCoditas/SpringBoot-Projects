package com.example.JWT_Basics1.Controller;

import com.example.JWT_Basics1.DTO.RequestDetailsDTO;
import com.example.JWT_Basics1.DTO.LoginResponseDTO;
import com.example.JWT_Basics1.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody RequestDetailsDTO requestDetailsDTO) {
        LoginResponseDTO response = authService.login(requestDetailsDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RequestDetailsDTO requestDetailsDTO )
    {
        authService.signup(requestDetailsDTO);
        return ResponseEntity.ok("User added.");
    }


}
