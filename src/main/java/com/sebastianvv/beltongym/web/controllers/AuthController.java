package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.repositories.UserRepository;
import com.sebastianvv.beltongym.domain.services.JwtService;
import com.sebastianvv.beltongym.persistence.entities.LoginRequest;
import com.sebastianvv.beltongym.persistence.entities.LoginResponse;
import com.sebastianvv.beltongym.persistence.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token, user);
    }
}
