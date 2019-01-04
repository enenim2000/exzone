package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum SettlementStatus implements PersistableEnum<String> {
    NOT_SETTLED("Not_Settled"),
    SETTLED("Settled"),
    REVERSED("Reversed");

    String value;

    public String getValue(){
        return value;
    }

    SettlementStatus(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<SettlementStatus, String> {
        public Converter() {
            super(SettlementStatus.class);
        }
    }
}
