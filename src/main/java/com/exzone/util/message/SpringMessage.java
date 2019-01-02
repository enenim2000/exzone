package com.exzone.util.message;

public class SpringMessage {
    public static String msg(String key) {
        return PropertyUtil.msg(key);
    }
}
