package com.demo;

import com.demo.util.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends BaseJunit{

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testSaveString() {

        redisUtil.save2Redis("test111","111",0);
    }
}
