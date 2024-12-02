package org.gzdieheart.authx.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * JWT服务接口
 */

public interface JwtService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
}
