package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum TransactionStatus implements PersistableEnum<Integer> {
    PAID(0),
    PENDING(1),
    FAILED(2),
    REVERSED(3),
    NEGOTIATING(4),
    PARTIAL_PAYMENT(5);

    private Integer value;

    public Integer getValue(){
        return value;
    }

    TransactionStatus(Integer value){
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<TransactionStatus, Integer> {
        public Converter() {
            super(TransactionStatus.class);
        }
    }

}
