package com.exzone.util.message;

import com.exzone.util.RequestUtil;

public class EntityMessage {
    private static final String FILE_NAME = "entity";

    public static String msg(String key) {
        return PropertyUtil.msg(key, RequestUtil.getLang(), FILE_NAME);
    }
}
