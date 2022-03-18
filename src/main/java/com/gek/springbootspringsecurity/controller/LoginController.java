package com.gek.springbootspringsecurity.controller;

import com.gek.springbootspringsecurity.domain.ResponseResult;
import com.gek.springbootspringsecurity.domain.User;
import com.gek.springbootspringsecurity.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private loginService loginService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return  loginService.login(user);
    }
}