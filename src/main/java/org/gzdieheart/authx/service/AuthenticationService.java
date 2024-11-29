package org.gzdieheart.authx.service;

import org.gzdieheart.authx.dao.request.SignUpRequest;
import org.gzdieheart.authx.dao.request.SigninRequest;
import org.gzdieheart.authx.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
