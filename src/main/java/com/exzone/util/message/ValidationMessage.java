package com.exzone.util.message;

import com.exzone.util.RequestUtil;

public class ValidationMessage {
    private static final String FILE_NAME = "validation";

    public static String msg(String key) {
        return PropertyUtil.msg(key, RequestUtil.getLang(), FILE_NAME);
    }
}
