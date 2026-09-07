package com.intelliguru.configuration.service;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tools.jackson.databind.ObjectMapper;

import java.io.FileReader;

public class ConfigurationService {
    private final JedisPool jedisPool;
    private final ObjectMapper objectMapper;

    public ConfigurationService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        this.objectMapper = new ObjectMapper();
    }

    public void put(String key, Object value, int ttlSeconds) {
        try (Jedis jedis = jedisPool.getResource()) {
            String jsonValue = objectMapper.writeValueAsString(value);
            if (ttlSeconds > 0) {
                jedis.setex(key, ttlSeconds, jsonValue);
            } else {
                jedis.set(key, jsonValue);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to put value into cache", e);
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        try (Jedis jedis = jedisPool.getResource()) {
            String jsonValue = jedis.get(key);
            if (jsonValue == null) {
                return null;
            }
            return objectMapper.readValue(jsonValue, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get value from cache", e);
        }
    }

    public void delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(key);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete value from cache", e);
        }
    }





































}
