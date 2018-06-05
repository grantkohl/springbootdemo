package com.demo.util;

import com.demo.config.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;
import java.util.Map.Entry;

@Service
public class RedisUtil {

	private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

	@Autowired
	private RedisConfig redisConfig;

	/**
	 * 存字符串类型的数据到redis
	 * @param key
	 * @param value
	 * @param expireSecond key过期时间：秒
	 * @return
	 * @throws Exception
	 */
	public boolean save2Redis( String key, String value, int expireSecond) {
		Jedis jedis = null;
		JedisSentinelPool pool = null;
		try {
			pool = redisConfig.getJedisSentinelPool();
			jedis = pool.getResource();
			if (expireSecond > 0) {
				jedis.setex(key, expireSecond, value);
			} else {
				jedis.set(key, value);
			}
			return true;
		} catch (JedisException e) {
			logger.error("平台id:{},存字符串类型的数据到redis失败,key:{}", key, e);
			throw e;
		} catch (Exception e) {
			logger.error("redis error", e);
			throw e;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public  <T> T get(String key) {
		Jedis jedis = null;
		try {
			JedisSentinelPool pool = redisConfig.getJedisSentinelPool();
//			JedisPool pool = redisConfig.getJedisPool();
			jedis = pool.getResource();
			byte[] value = jedis.get(key.getBytes());
			if (value == null) {
				return null;
			}
			return (T) SerializeUtil.unserialize(value);
		} catch (Exception e) {
			logger.error("jedis异常", e);
			throw e;
		} finally {
		}
	}
}
