package com.demo.config;

import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final String REDIS_IP;
    public static final Integer REDIS_PORT;
    public static final String REDIS_SENTINEL;
    public static final String REDIS_MASTER_NAME;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Config.class.getResourceAsStream("/dev/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        REDIS_IP = properties.getProperty("redisIp");
        REDIS_PORT = Integer.parseInt(properties.getProperty("redisPort"));

        REDIS_SENTINEL = properties.getProperty("redisSentinel");
        REDIS_MASTER_NAME = properties.getProperty("redisMasterName");

    }

}
