package com.example.decorators;

import com.example.cipher.CipherTemplate;

// Concrete class extending the abstract class
public class PreprocessDecorator extends CipherDecorator {

    public PreprocessDecorator(CipherTemplate decoratedCipher) {
        super(decoratedCipher);
    }

    @Override
    public String encrypt(String message) {
        String processedMessage = preprocessMessage(message);
        return decoratedCipher.encrypt(processedMessage);
    }

    private String preprocessMessage(String message) {
        // Solo deja el texto después del guión
        int corte = message.indexOf('-');
        message = message.substring(corte + 1);
        return message;
    }
}
