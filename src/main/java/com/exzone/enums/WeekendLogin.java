package com.exzone.enums;

import com.exzone.interfaces.PersistableEnum;

public enum WeekendLogin implements PersistableEnum<Integer> {
    NO(0),
    YES(1);
    
    private Integer id;

    public Integer getValue(){
        return id;
    }

    WeekendLogin(Integer id){
        this.id = id;
    }

    public static class Converter extends EnumValueTypeConverter<WeekendLogin, Integer> {
        public Converter() {
            super(WeekendLogin.class);
        }
    }
}
