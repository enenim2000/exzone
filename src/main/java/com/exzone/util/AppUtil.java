package com.exzone.util;

import com.exzone.ExZoneApplication;

public class AppUtil {
    public static String basePackage(){
        return ExZoneApplication.class.getPackage().getName();
    }
}