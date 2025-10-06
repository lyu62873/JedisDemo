package com.leyu.jedisdemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

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

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

}
