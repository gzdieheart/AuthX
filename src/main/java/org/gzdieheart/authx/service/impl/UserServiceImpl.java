package org.gzdieheart.authx.service.impl;

import org.gzdieheart.authx.entities.Authority;
import org.gzdieheart.authx.mapper.AuthorityMapper;
import org.gzdieheart.authx.utils.authenticate.GenerateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.gzdieheart.authx.mapper.UserMapper;
import org.gzdieheart.authx.service.UserService;
import org.gzdieheart.authx.entities.User;
import org.gzdieheart.authx.restful.error.BusinessException;
import org.gzdieheart.authx.restful.error.BusinessErrorCode;
import org.gzdieheart.authx.dto.utils.GenerateUsername;

import lombok.RequiredArgsConstructor;

import java.security.NoSuchAlgorithmException;
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
    private final UserMapper userMapper;
    private final AuthorityMapper authorityMapper;

    @Value("${authX.generate-username.algorithm}")
    private String algorithm;
    @Value("${authX.generate-username.hash-length}")
    private int hashLength;
    @Value("${authX.generate-username.counter-length}")
    private int counterLength;

    @Override
    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
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

    public String generateUniqueUsername(String email) {
        String username = null;
        try {
            String localPart = email.split("@")[0];
            int counter = 1;
            GenerateUsername generator = new GenerateUsername(localPart, algorithm, hashLength, counterLength, counter);
            username = GenerateUtil.generateUsername(generator);
            while (userMapper.findByUsername(username).isPresent()) {
                String hash = username.split("#")[1].substring(0, generator.getHashLength());
                counter++;
                username = localPart + "#" + hash + String.format("%0" + counterLength + "d", counter);
            }
        }
        catch (NoSuchAlgorithmException e) {
            throw new BusinessException(BusinessErrorCode.Generate_Username_Error);
        }
        catch(Exception e) {
            throw new BusinessException(BusinessErrorCode.Generate_Username_Error, e.getMessage());
        }
        return username;
    }

    @Override
    public boolean saveUser(User user) {
        return userMapper.insertOrUpdate(user);
    }
}
