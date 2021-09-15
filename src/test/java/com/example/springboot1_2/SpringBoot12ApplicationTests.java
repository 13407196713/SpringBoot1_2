package com.example.springboot1_2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringBoot12ApplicationTests {


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        //增 key：name，value：ay
        redisTemplate.opsForValue().set("name","ay");
        String name = (String)redisTemplate.opsForValue().get("name");
        System.out.println(name);

        //删除
        redisTemplate.delete("name");

        //更新
        redisTemplate.opsForValue().set("name1","al");

        //查询
        String name1 = stringRedisTemplate.opsForValue().get("name1");
        System.out.println(name1);
    }

}
