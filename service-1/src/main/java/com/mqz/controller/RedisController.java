package com.mqz.controller;

import com.mqz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mqz
 * @description
 * @since 2020/6/24
 */
@RestController
@RequestMapping(path = "/redis" )
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping(value = "/session/set")
    public Map<String,Object> setSession(HttpServletRequest request){
        User stu1 = (User) redisTemplate.opsForValue().get("A1");




        String sessionId = request.getSession().getId();
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        int port = request.getRemotePort();


        request.getSession().setAttribute("user_"+stu1.getUserName(),stu1);


        Map<String,Object> map = new HashMap<>(5);
        map.put("sessionId",sessionId);
        map.put("uri",uri);
        map.put("url",url);
        map.put("port",port);
        return map;
    }

    @GetMapping(value = "/session/get")
    public Map<String,Object> getSession(HttpServletRequest request){

        String sessionId = request.getSession().getId();
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        int port = request.getRemotePort();

        User stu1 = (User) redisTemplate.opsForValue().get("A1");
        request.getSession().getAttribute("user_"+stu1.getUserName());


        Map<String,Object> map = new HashMap<>(5);
        map.put("sessionId",sessionId);
        map.put("uri",uri);
        map.put("url",url);
        map.put("port",port);
        map.put("sessionValue",stu1.toString());
        return map;
    }





}
