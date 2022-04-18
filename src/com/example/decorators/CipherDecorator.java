package com.example.decorators;

import com.example.cipher.CipherTemplate;

public abstract class CipherDecorator extends CipherTemplate {
    // Protected variable
    protected CipherTemplate decoratedCipher;

    // Method 1
    // Abstract class method
    public CipherDecorator(CipherTemplate decoratedCipher) {
        // This keyword refers to current object itself
        this.decoratedCipher = decoratedCipher;
    }

    // Method 2
    // Outside abstract class
    public String encrypt(String message) {
        return decoratedCipher.encrypt(message);
    }
}
