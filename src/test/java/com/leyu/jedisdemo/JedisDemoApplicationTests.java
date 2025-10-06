package com.leyu.jedisdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JedisDemoApplicationTests {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("43.166.246.21", 6379);
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "张三"); //这里的result指set的结果是否成功
        System.out.println("result: " + result);
        String getResult = jedis.get("name");
        System.out.println("getResult: " + getResult);
    }

    @Test
    void testHash() {
        Map<String, String> pokeMap = new HashMap<>();
        pokeMap.put("1000", "赛富豪");
        pokeMap.put("386", "代欧奇希斯");

        String result = jedis.hmset("pokemon", pokeMap);
        System.out.println("result: " + result);
        String getResult = jedis.hget("pokemon", "1000");
        System.out.println("1000 getResult: " + getResult);
        Map<String, String> pokemon = jedis.hgetAll("pokemon");
        System.out.println("pokemon: " + pokemon);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
