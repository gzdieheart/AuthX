package org.gzdieheart.authx.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 用户服务接口
 */

public interface UserService {
    UserDetailsService userDetailsService();
}
