package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum UserType implements PersistableEnum<String> {
    CONSUMER("Consumer"),
    STAFF("Staff");

    String value;

    public String getValue(){
        return value;
    }

    UserType(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<UserType, String> {
        public Converter() {
            super(UserType.class);
        }
    }
}
