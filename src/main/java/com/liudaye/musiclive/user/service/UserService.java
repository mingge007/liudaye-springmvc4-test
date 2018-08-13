package com.liudaye.musiclive.user.service;

import com.liudaye.musiclive.user.domain.UserBaseInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by new on 2016/6/15.
 */
@Service(value = "userService")
public class UserService {

    @Cacheable(value = "user#600", key = "targetClass +  '.user.userId_' + #userId+'#100'")
    public UserBaseInfo getUserInfoByUserId(Long userId) {
        System.out.println("getUserInfoByUserId do");
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setUserId(userId);
        userBaseInfo.setName(userId.toString());
        return userBaseInfo;
    }

    @Cacheable(value = "user#600", key = "targetClass +  '.user.username_' + #username+'#200'")
    public UserBaseInfo getUserInfoByUsername(Long username) {
        System.out.println("getUserInfoByUserId do");
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setUserId(username);
        userBaseInfo.setName(username.toString());
        return userBaseInfo;
    }
}