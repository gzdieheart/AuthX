package org.gzdieheart.authx.service;

import org.gzdieheart.authx.dao.request.SignUpRequest;
import org.gzdieheart.authx.dao.request.SigninRequest;
import org.gzdieheart.authx.dao.response.JwtAuthenticationResponse;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 鉴权服务接口
 */

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
