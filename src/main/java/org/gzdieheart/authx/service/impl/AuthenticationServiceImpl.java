package org.gzdieheart.authx.service.impl;

import org.gzdieheart.authx.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.gzdieheart.authx.dto.request.SignUpRequest;
import org.gzdieheart.authx.dto.request.SignInRequest;
import org.gzdieheart.authx.entities.Role;
import org.gzdieheart.authx.entities.User;
import org.gzdieheart.authx.mapper.UserMapper;
import org.gzdieheart.authx.service.AuthenticationService;
import org.gzdieheart.authx.service.JwtService;
import org.gzdieheart.authx.utils.authenticate.GenerateUtil;

import lombok.RequiredArgsConstructor;

import java.security.NoSuchAlgorithmException;

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
    //private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    /*@Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
            .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER).build();
        userMapper.insertOrUpdate(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }*/
    @Override
    public String signup(SignUpRequest request) {
        String username = userService.generateUniqueUsername(request.getEmail());
        var user = User.builder().firstName(request.getFirstname()).lastName(request.getLastname())
            .email(request.getEmail()).username(username).password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER).build();
        userMapper.insertOrUpdate(user);
        var jwt = jwtService.generateToken(user);
        return jwt;
    }

    /*@Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userMapper.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }*/
    @Override
    public String signin(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userMapper.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return jwt;
    }
}
