package com.github.bh.hjob.mq;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author xiaobenhai
 */
public class RedisQueue {

    private JedisPool jedisPool;

    public RedisQueue setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        return this;
    }

    /**
     * blocking
     * remove and get last item from queue:BRPOP
     */
    public String takeFromHead(String key, int timeout) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            List<String> retMsgs = jedis.blpop(timeout, key);
            if (CollectionUtils.isNotEmpty(retMsgs) && retMsgs.size() > 1 && StringUtils.isNotBlank(retMsgs.get(1))) {
                String retMsg = retMsgs.get(1);
                return retMsg;
            }
            return StringUtils.EMPTY;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public void pushFromTail(String key, String value) {
        Jedis jedis = this.jedisPool.getResource();
        try {
            jedis.rpush(key, value);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }

    public long size(String key) {
        long size;
        Jedis jedis = this.jedisPool.getResource();
        try {
            size = jedis.llen(key);
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return size;
    }

    public String takeFromHead(String key) throws Exception {
        return takeFromHead(key, 0);
    }


}
