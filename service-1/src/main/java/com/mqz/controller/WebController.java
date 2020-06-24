package com.mqz.controller;

import cn.hutool.json.JSONUtil;
import com.mqz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqz
 * @description
 * @since 2020/6/24
 */
@RestController
@RequestMapping(value = "/web")
public class WebController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/1")
    public User testRedis1() {
        User user = new User();
        user.setUserName("test1");
        user.setEmail("11飞@163.com");
        redisTemplate.opsForValue().set("A1", user);
        User stu1 = (User) redisTemplate.opsForValue().get("A1");
        return stu1;
    }


    @GetMapping("/2")
    public User testRedis2() {
        User user = new User();
        user.setUserName("test2");
        user.setEmail("11费@QQ.com");
        stringRedisTemplate.opsForValue().set("A2", JSONUtil.toJsonStr(user));
        User stu1 = JSONUtil.toBean(stringRedisTemplate.opsForValue().get("A2"), User.class);
        return stu1;
    }

}
