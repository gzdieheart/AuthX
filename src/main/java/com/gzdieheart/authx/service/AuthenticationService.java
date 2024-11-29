package com.gzdieheart.authx.service;

import com.gzdieheart.authx.dao.request.SignUpRequest;
import com.gzdieheart.authx.dao.request.SigninRequest;
import com.gzdieheart.authx.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
