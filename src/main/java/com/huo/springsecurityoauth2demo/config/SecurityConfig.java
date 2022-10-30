package com.huo.springsecurityoauth2demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author 小源同学
 * @Date 2022 01 15 19 22
 * @Describe Security 配置类
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth/authorize**", "/login/**", "logout/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
        ;
    }
}

