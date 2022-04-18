package com.example.factory;

import com.example.cipher.Cesar;
import com.example.cipher.CipherTemplate;
import com.example.cipher.Invertido;
import com.example.cipher.Vocales;
import com.example.decorators.PreprocessDecorator;


public class CipherFactory {
    //Comment
    public CipherTemplate getCipher(String cipherType) {
        if (cipherType == null) {
            return null;
        }
        if (cipherType.equalsIgnoreCase("CESAR")) {
            CipherTemplate cesar = new Cesar();
            return new PreprocessDecorator(cesar);

        } else if (cipherType.equalsIgnoreCase("INVERTIDO")) {
            CipherTemplate invertido = new Invertido();
            return new PreprocessDecorator(invertido);

        } else if (cipherType.equalsIgnoreCase("VOCALES")) {
            CipherTemplate vocales = new Vocales();
            return new PreprocessDecorator(vocales);
        }

        return null;
    }
    
}
