package com.github.bh.hjob.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xiaobenhai
 */
public class EventLooper<T> implements InitializingBean, DisposableBean {

    private final Logger LOGGER = LoggerFactory.getLogger(EventLooper.class);
    private static final long DEFAULT_SLEEP_TIME = 1;

    private EventRedisQueue<T> eventQueue;
    private EventQueueListener<T> listener;
    private long sleepTime = DEFAULT_SLEEP_TIME;
    //执行任务线程池
    private ExecutorService listenerThread = Executors.newSingleThreadExecutor();
    //启停控制标志
    private volatile AtomicBoolean shutdown = new AtomicBoolean(false);

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("[EventLooper] is starting");
        listenerThread.execute(new Runnable() {
            @Override
            public void run() {
                while (!shutdown.get()) {
                    try {
                        T obj = eventQueue.dequeue();
                        if (null == obj) {
                            continue;
                        }
                        LOGGER.info("[EventLooper] msg:{}", obj);
                        listener.onMessage(obj);
                    } catch (Exception e) {
                        LOGGER.warn("[run] Exception => {}", e.getMessage(), e);
                    }
                }
            }
        });
    }

    public EventRedisQueue<T> getEventQueue() {
        return eventQueue;
    }

    public void setEventQueue(EventRedisQueue<T> eventQueue) {
        this.eventQueue = eventQueue;
    }

    public EventQueueListener<T> getListener() {
        return listener;
    }

    public void setListener(EventQueueListener<T> listener) {
        this.listener = listener;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("destroy is starting");
        shutdown();
        LOGGER.info("destroy is ending");
    }

    private void shutdown() {
        try {
            shutdown.compareAndSet(false, true);
            listenerThread.shutdown();
        } catch (Exception e) {
            LOGGER.error("shutdown,exception:{}", e.getMessage());
        }
    }

}
