package com.gek.springbootspringsecurity;

import com.gek.springbootspringsecurity.mapper.UserMapper;
import com.gek.springbootspringsecurity.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringbootSpringsecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectList(null));
    }
    @Test
    public  void TestBCryptPasswordEncoder() throws Exception {
        Claims jwt = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyYzlkNjkzYzEwOWI0Y2NkOGI0Nzg1YWQyZmI2Y2I4MiIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY0NzU2MzkwOCwiZXhwIjoxNjQ3NTY3NTA4fQ.jcSvmpqGj9K0hWTr3IsUTZ_ya_eFIZnv647ADLo9C1k");
        System.out.println(jwt);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123456");
//        boolean matches = bCryptPasswordEncoder.matches("123456", "$2a$10$EwftxIv9Vpk9hyxmescfeubQ/rHcUcKUn325tzurblRkf2s5FW.66");
//        System.out.println(encode);
//        System.out.println(matches);
    }

}
