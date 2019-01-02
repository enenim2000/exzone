package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum ExchangeType implements PersistableEnum<String> {
    CASH("Cash"),
    GOODS("Goods");

    String value;

    public String getValue(){
        return value;
    }

    ExchangeType(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<ExchangeType, String> {
        public Converter() {
            super(ExchangeType.class);
        }
    }
}
