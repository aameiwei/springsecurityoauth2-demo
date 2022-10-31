package com.huo.springsecurityoauth2demo.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
       return authentication.getPrincipal();
}

    /**
     * 获取 JwtToken 解析的信息
     *
     * @param authentication
     * @return
     */
    @RequestMapping("/getJwtToken")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader("Authorization");
        System.out.println(authorization);
        String token = authorization.substring(authorization.indexOf("bearer") + 7);
        return Jwts.parser().setSigningKey("TEST_KEY".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
    }

}
