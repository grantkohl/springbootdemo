package com.demo.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig implements EnvironmentAware {

    private JedisPool jedisPool;

    private JedisSentinelPool jedisSentinelPool;

    private void ini(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
//        jedisPool = new JedisPool(config, Config.REDIS_IP, Config.REDIS_PORT, 10000);
        Set<String> ips = new HashSet<>();
        ips.add("192.168.96.48:28001");
        jedisSentinelPool = new JedisSentinelPool("byMaster8001",ips,config,10000);
    }

    public  JedisSentinelPool getJedisSentinelPool() {
        return jedisSentinelPool;
    }

    /**
     * 凡注册到Spring容器内的bean，实现了EnvironmentAware接口重写setEnvironment方法后，
     * 在工程启动时可以获得application.properties的配置文件配置的属性值。
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.ini();
    }
}
