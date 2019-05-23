package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum AccountType implements PersistableEnum<String> {
    SAVINGS("Savings"),
    CURRENT("Current"),
    FIXED_DEPOSIT("Fixed_Deposit"),
    RECURRING_DEPOSIT("Recurring_Deposit");

    String value;

    public String getValue(){
        return value;
    }

    AccountType(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<AccountType, String> {
        public Converter() {
            super(AccountType.class);
        }
    }
}
