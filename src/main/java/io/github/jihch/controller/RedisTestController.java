package io.github.jihch.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisTestController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key") String key){
        String value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
        return value;
    }

    @RequestMapping("/set/{key}/{value}")
    public void get(@PathVariable("key") String key, @PathVariable("value") String value){
        redisTemplate.opsForValue().set(key, value);
    }


}
