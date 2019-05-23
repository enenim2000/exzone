package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum NotificationType implements PersistableEnum<String> {
    EMAIL("Email"),
    SMS("Sms"),
    PUSH("Push");

    String value;

    public String getValue(){
        return value;
    }

    NotificationType(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<NotificationType, String> {
        public Converter() {
            super(NotificationType.class);
        }
    }
}
