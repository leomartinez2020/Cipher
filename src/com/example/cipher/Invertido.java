package com.example.cipher;

public class Invertido implements CipherType {
    @Override
    public String encrypt(String message) {
        StringBuilder newText = new StringBuilder(message);
        return newText.reverse().toString();
    }
}
