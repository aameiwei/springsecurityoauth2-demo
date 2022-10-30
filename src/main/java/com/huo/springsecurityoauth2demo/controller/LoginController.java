package com.huo.springsecurityoauth2demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
       return authentication.getPrincipal();
}

}
