package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum AcceptanceStatus implements PersistableEnum<String> {
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    CANCELLED("Cancelled"),
    PENDING("Pending");

    String value;

    public String getValue(){
        return value;
    }

    AcceptanceStatus(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<AcceptanceStatus, String> {
        public Converter() {
            super(AcceptanceStatus.class);
        }
    }
}
