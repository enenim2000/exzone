package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum WorthStatus implements PersistableEnum<String> {
    NEGOTIABLE("Negotiable"),
    NON_NEGOTIABLE("Non_Negotiable");

    String value;

    public String getValue(){
        return value;
    }

    WorthStatus(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<WorthStatus, String> {
        public Converter() {
            super(WorthStatus.class);
        }
    }
}
