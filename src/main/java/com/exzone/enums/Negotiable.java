package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum Negotiable implements PersistableEnum<String> {
    YES("Yes"),
    NO("No");

    String value;

    public String getValue(){
        return value;
    }

    Negotiable(String value) {
        this.value = value;
    }

    public static class Converter extends EnumValueTypeConverter<Negotiable, String> {
        public Converter() {
            super(Negotiable.class);
        }
    }
}
