package me.kakao.logintest.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVo selectUser() {
        UserVo user = new UserVo();
        user.setUserId("user");
        user.setPassword("password");
        user.setRole("USER");
        return user;
    }
}
