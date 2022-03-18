package com.gek.springbootspringsecurity.service.impl;

import com.gek.springbootspringsecurity.domain.LoginUser;
import com.gek.springbootspringsecurity.domain.ResponseResult;
import com.gek.springbootspringsecurity.domain.User;
import com.gek.springbootspringsecurity.service.loginService;
import com.gek.springbootspringsecurity.utils.JwtUtil;
import com.gek.springbootspringsecurity.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
//        通过authenticationManager进行认证
        Authentication authenticate = authenticationManager.authenticate(token);
//        如果认证没通过，给个提示
        if(Objects.isNull(authenticate)){
            throw  new RuntimeException("用户名或者密码错误");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId= loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        HashMap<String, String> map = new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+userId,loginUser);
        return new ResponseResult(200,"登录成功",map);
    }
}
