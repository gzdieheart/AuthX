package org.gzdieheart.authx.service;

import org.gzdieheart.authx.dto.request.SignUpRequest;
import org.gzdieheart.authx.dto.request.SignInRequest;

import java.security.NoSuchAlgorithmException;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 鉴权服务接口
 */

public interface AuthenticationService {
    //JwtAuthenticationResponse signup(SignUpRequest request);
    //JwtAuthenticationResponse signin(SigninRequest request);
    String signup(SignUpRequest request);
    String signin(SignInRequest request);
}
