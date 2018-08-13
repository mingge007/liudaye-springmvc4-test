package com.liudaye.musiclive.user.controller;


import com.liudaye.musiclive.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liuhongming
 * @version V1.0
 * @date May 20, 2015 3:53:45 PM
 * @Description: TODO(用一句话描述该文件做什么)
 */
@Controller
@RequestMapping("/test")
public class TestCtrl {
    @Autowired
    UserService userService;

    @RequestMapping("/getUserInfo.htm")
    @ResponseBody
    public Map getUserInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map backMap = new HashMap();
        Long userId = Long.valueOf(request.getParameter("userId"));

        backMap.put("userInfo", userService.getUserInfoByUserId(userId));
        return backMap;
    }

    @RequestMapping("/getUserInfoByName.htm")
    @ResponseBody
    public Map getUserInfoByUsername(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map backMap = new HashMap();
        Long userId = Long.valueOf(request.getParameter("userId"));

        backMap.put("userInfo", userService.getUserInfoByUsername(userId));
        return backMap;
    }

    @Cacheable(value = "userInfo#300", key = "targetClass + '.getUserInfo2.userId_' + #userId")
    @RequestMapping("/getUserInfo2.htm")
    @ResponseBody
    public Map getUserInfo2(HttpServletRequest request, HttpServletResponse response, @RequestParam("userId") Long userId) throws Exception {
        Map<String, Object> backMap = new HashMap<String, Object>();
        System.out.println("getUserInfo2 do");
        backMap.put("userInfo", userService.getUserInfoByUserId(userId));
        return backMap;
    }


}
