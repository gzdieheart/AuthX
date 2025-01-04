package org.gzdieheart.authx.service;

import org.gzdieheart.authx.entities.User;
/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * JWT服务接口
 */

public interface JwtService {
    String extractUserName(String token);
    String generateToken(User user);
    boolean isTokenValid(String token, User user);
}
