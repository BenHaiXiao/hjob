package com.github.bh.hjob.mq;

/**
 * @author xiaobenhai
 */
public interface EventQueueListener<T> {

    void onMessage(T t) throws Exception;
}
