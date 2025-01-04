package org.gzdieheart.authx.service.impl;

import org.gzdieheart.authx.entities.Authority;
import org.gzdieheart.authx.mapper.AuthorityMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.gzdieheart.authx.mapper.UserMapper;
import org.gzdieheart.authx.service.UserService;
import org.gzdieheart.authx.entities.User;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
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
    private final UserMapper userMapper;
    private final AuthorityMapper authorityMapper;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userMapper.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
        //if (!user.isActivated()) {
        //    throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        //}

        List<Authority> list = authorityMapper.getListByUserId(user.getId());
        //user.setAuthorities(list);

        List<GrantedAuthority> grantedAuthorities = list.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                grantedAuthorities);
    }
}
