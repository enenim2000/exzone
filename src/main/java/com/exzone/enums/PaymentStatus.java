package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum PaymentStatus implements PersistableEnum<String> {
    NOT_PAID("Not_Paid"),
    PAID("Paid"),
    REVERSED("Reversed");

    String value;

    public String getValue(){
        return value;
    }

    PaymentStatus(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<PaymentStatus, String> {
        public Converter() {
            super(PaymentStatus.class);
        }
    }
}
