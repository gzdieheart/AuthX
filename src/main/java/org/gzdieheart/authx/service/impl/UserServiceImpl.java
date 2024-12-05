package org.gzdieheart.authx.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import org.gzdieheart.authx.repository.UserRepository;
import org.gzdieheart.authx.repository.UserMapper;
import org.gzdieheart.authx.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 用户服务接口
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    //private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userMapper.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
                //return userRepository.findByEmail(username)
                //    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
