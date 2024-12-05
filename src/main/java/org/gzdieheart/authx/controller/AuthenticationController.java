package org.gzdieheart.authx.controller;

import org.gzdieheart.authx.restful.resp.R;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.gzdieheart.authx.dao.request.SignUpRequest;
import org.gzdieheart.authx.dao.request.SigninRequest;
import org.gzdieheart.authx.dao.response.JwtAuthenticationResponse;
import org.gzdieheart.authx.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 鉴权控制器
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    //public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
    //    return ResponseEntity.ok(authenticationService.signup(request));
    //}
    public R signup(@RequestBody SignUpRequest request) {
        return R.success().data("token", authenticationService.signup(request));
        //return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    //public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
    //    return ResponseEntity.ok(authenticationService.signin(request));
    //}
    public R signin(@RequestBody SigninRequest request) {
        return R.success().data("token", authenticationService.signin(request));
        //return ResponseEntity.ok(authenticationService.signin(request));
    }
}
