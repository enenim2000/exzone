package com.exzone.util;

import com.exzone.interfaces.IPasswordEncoder;

public class PasswordEncoder implements IPasswordEncoder {

    private Jargon2PasswordEncoder passwordEncoder = new Jargon2PasswordEncoder();

    @Override
    public String encode(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}