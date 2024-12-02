package org.gzdieheart.authx.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.gzdieheart.authx.dao.request.SignUpRequest;
import org.gzdieheart.authx.dao.request.SigninRequest;
import org.gzdieheart.authx.dao.response.JwtAuthenticationResponse;
import org.gzdieheart.authx.entities.Role;
import org.gzdieheart.authx.entities.User;
import org.gzdieheart.authx.repository.UserRepository;
import org.gzdieheart.authx.service.AuthenticationService;
import org.gzdieheart.authx.service.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 鉴权服务实现
 */

@Service
@RequiredArgsConstructor
public class
AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
            .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
