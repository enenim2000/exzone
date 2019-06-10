package com.exzone.interfaces;

public interface IPasswordEncoder {

    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}