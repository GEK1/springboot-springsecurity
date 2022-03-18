package com.gek.springbootspringsecurity.service;

import com.gek.springbootspringsecurity.domain.ResponseResult;
import com.gek.springbootspringsecurity.domain.User;

public interface loginService {

     ResponseResult login(User user);
}
