/**
 * Copyright (c) 2015 21CN.COM . All rights reserved.
 *
 * Description: newEDM
 *
 * Modified log: ------------------------------------------------------ Ver.
 * Date Author Description
 * ------------------------------------------------------ 1.0 2015年2月9日 xiaobenhai
 * created.
 */
package com.github.bh.hjob.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xiaobenhai
 */
public class GsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(GsonUtils.class);
    private static GsonBuilder gsonBuilder;

    private static GsonBuilder gsonBuilderWithoutNull;

    static {
        gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls();
        gsonBuilderWithoutNull = new GsonBuilder()
                .registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static final <T> T fromJson(String json, Class<T> type) {
        Gson gson = gsonBuilder.create();
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            LOGGER.warn("[fromJson] Could not parse json -> {}, to type -> {},e -> {}", json, type,e);
        }
        return null;
    }

    public static final <T> T fromJson(String json, Type type) {
        Gson gson = gsonBuilder.create();
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            LOGGER.warn("[fromJson] Could not parse json -> {}, to type -> {},e -> {}", json, type,e);
        }
        return null;
    }

    public static final String toJson(Object obj, Type type) {
        Gson gson = gsonBuilder.create();
        try {
            return gson.toJson(obj, type);
        } catch (Exception e) {
            LOGGER.warn("[toJson] Could not tojson obj -> {}, to type -> {},e -> {}", obj, type,e);
        }
        return null;
    }

    public static final String toJson(Object obj) {
        Gson gson = gsonBuilder.create();
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            LOGGER.warn("[toJson] Could not tojson obj -> {}, to type -> {},e -> {}", obj,e);
        }
        return null;
    }

    public static final String toJsonWithoutNull(Object obj, Type type) {
        Gson gson = gsonBuilderWithoutNull.create();
        try {
            return gson.toJson(obj, type);
        } catch (Exception e) {
            LOGGER.warn("[toJsonWithoutNull] Could not tojson obj -> {}, to type -> {},e->{}", obj,type,e);
        }
        return null;
    }

    public static final String toJsonWithoutNull(Object obj) {
        Gson gson = gsonBuilderWithoutNull.create();
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            LOGGER.warn("[toJsonWithoutNull] Could not tojson obj -> {}, e->{}", obj,e);
        }
        return null;
    }

}
