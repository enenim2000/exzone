package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum PurchaseStatus implements PersistableEnum<String> {
    AVAILABLE("Available"),
    NOT_AVAILABLE("Not_Available");

    String value;

    public String getValue(){
        return value;
    }

    PurchaseStatus(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<PurchaseStatus, String> {
        public Converter() {
            super(PurchaseStatus.class);
        }
    }
}
