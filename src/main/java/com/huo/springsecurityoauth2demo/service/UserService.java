package com.huo.springsecurityoauth2demo.service;

import com.huo.springsecurityoauth2demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author 小源同学
 * @Date 2022 01 15 19 21
 * @Describe  自定登录逻辑
 **/
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123");
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}

