package org.gzdieheart.authx.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.gzdieheart.authx.mapper.AuthorityMapper;
import org.gzdieheart.authx.mapper.UserMapper;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.gzdieheart.authx.entities.Authority;
import org.gzdieheart.authx.entities.User;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class UserModelDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);

    //@Autowired(required = false)
    private final UserMapper userMapper;
    //@Autowired(required = false)
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
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }

    /*@Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating user '{}'", login);

        if (new EmailValidator().isValid(login, null)) {
            return userMapper.findOneWithAuthoritiesByEmailIgnoreCase(login)
                    .map(user -> createSpringSecurityUser(login, user))
                    .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
        }

        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("username", lowercaseLogin);
        List<User> list = userMapper.selectList(wrapper);
        if (list.size() > 0) {
            return createSpringSecurityUser(lowercaseLogin, list.get(0));
        }
        else
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        //return userMapper.findOneWithAuthoritiesByUsername(lowercaseLogin)
        //   .map(user -> createSpringSecurityUser(lowercaseLogin, user))
        //   .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }

        List<Authority> list = authorityMapper.getListByUserId(user.getId());
        //user.setAuthorities(list);

        List<GrantedAuthority> grantedAuthorities = list.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }*/
}
