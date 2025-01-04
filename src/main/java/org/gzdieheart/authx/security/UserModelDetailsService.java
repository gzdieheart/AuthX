package org.gzdieheart.authx.security;

import lombok.RequiredArgsConstructor;
import org.gzdieheart.authx.mapper.AuthorityMapper;
import org.gzdieheart.authx.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.gzdieheart.authx.entities.Authority;
import org.gzdieheart.authx.entities.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/12/14
 * 用户UserDetailsService配置
 */

@Component("userDetailsService")
@RequiredArgsConstructor
public class UserModelDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);

    private final UserMapper userMapper;
    private final AuthorityMapper authorityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.debug("Authenticating user '{}'", username);
        return userMapper.findByEmail(username)
                .map(user -> createSpringSecurityUser(username, user))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
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
