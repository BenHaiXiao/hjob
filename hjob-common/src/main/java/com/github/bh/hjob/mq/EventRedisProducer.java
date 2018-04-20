package com.github.bh.hjob.mq;
import com.github.bh.hjob.json.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaobenhai
 */
public class EventRedisProducer<T> {

    private final Logger logger = LoggerFactory.getLogger(EventRedisProducer.class);

    private RedisQueue redisQueue;
    private String queueKey;

    public EventRedisProducer() {
    }

    public EventRedisProducer(RedisQueue redisQueue) {
        this.redisQueue = redisQueue;
    }

    public EventRedisProducer(RedisQueue redisQueue, String queueKey) {
        this.redisQueue = redisQueue;
        this.queueKey = queueKey;
    }

    public void enqueue(T o) {
        String json = GsonUtils.toJson(o);
        if (logger.isDebugEnabled()) {
            logger.debug("[enqueue] Json => {}", json);
        }
        redisQueue.pushFromTail(queueKey, json);
    }

    public void enqueue(String queueKey, T o) throws Exception {
        if (StringUtils.isBlank(queueKey)) {
            throw new Exception("queue key can not be empty");
        }
        String json = GsonUtils.toJson(o);
        if (logger.isDebugEnabled()) {
            logger.debug("[enqueue] Json => {}", json);
        }
        redisQueue.pushFromTail(queueKey, json);
    }

    public RedisQueue getRedisQueue() {
        return redisQueue;
    }

    public void setRedisQueue(RedisQueue redisQueue) {
        this.redisQueue = redisQueue;
    }

    public String getQueueKey() {
        return queueKey;
    }

    public void setQueueKey(String queueKey) {
        this.queueKey = queueKey;
    }
}
