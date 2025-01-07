package org.gzdieheart.authx.service;

import org.gzdieheart.authx.entities.User;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 用户服务接口
 */

public interface UserService {
    public User getUserByEmail(String email);
    public org.springframework.security.core.userdetails.User createSpringSecurityUser(User user);
    public String generateUniqueUsername(String email);
    public boolean saveUser(User user);
}
