package com.github.bh.hjob.mq;

import com.github.bh.hjob.json.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaobenhai
 */
public class EventRedisQueue<T> extends EventRedisProducer<T> {

    private final Logger logger = LoggerFactory.getLogger(EventRedisQueue.class);
    private Class<T> clazz;

    public EventRedisQueue() {
        super();
    }

    public EventRedisQueue(RedisQueue redisQueue, String queueKey, Class<T> clazz) {
        super(redisQueue, queueKey);
        this.clazz = clazz;
    }

    public T dequeue() throws Exception {
        String eventMessage = getRedisQueue().takeFromHead(getQueueKey());
        if (logger.isDebugEnabled()) {
            logger.debug("[dequeue] eventMessage => {}", eventMessage);
        }
        T obj = (T) GsonUtils.fromJson(eventMessage, clazz);
        return obj;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
