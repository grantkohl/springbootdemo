package com.demo;

import com.demo.util.RedisUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends BaseJunit{

    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);


    @Autowired
    RedisUtil redisUtil;

    @Test
    public void testSaveString() {

        logger.info(logMsgPart);
        redisUtil.save2Redis("test111","111",0);
    }

    @Test
    public void getObj() {

        Long pid = 1300475444L;
//                1301625005L;
//        1300475444L;

        ProductKickbackInfoCacheDto suKickbackInfoDto = redisUtil.get("productsoa_product_validity_kickback_v1_" + pid);

    }
}
