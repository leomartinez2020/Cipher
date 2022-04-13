package com.example.decorators;

import com.example.cipher.CipherType;

public abstract class CipherDecorator implements CipherType {
    // Protected variable
    protected CipherType decoratedCipher;

    // Method 1
    // Abstract class method
    public CipherDecorator(CipherType decoratedCipher) {
        // This keyword refers to current object itself
        this.decoratedCipher = decoratedCipher;
    }

    // Method 2
    // Outside abstract class
    public String encrypt(String message) {
        return decoratedCipher.encrypt(message);
    }
}
