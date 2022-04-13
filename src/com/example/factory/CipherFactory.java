package com.example.factory;

import com.example.cipher.Cesar;
import com.example.cipher.CipherType;
import com.example.cipher.Invertido;
import com.example.cipher.Vocales;
import com.example.decorators.PreprocessDecorator;


public class CipherFactory {
    //Comment
    public CipherType getCipher(String cipherType) {
        if (cipherType == null) {
            return null;
        }
        if (cipherType.equalsIgnoreCase("CESAR")) {
            CipherType cesar = new Cesar();
            return new PreprocessDecorator(cesar);

        } else if (cipherType.equalsIgnoreCase("INVERTIDO")) {
            CipherType invertido = new Invertido();
            return new PreprocessDecorator(invertido);

        } else if (cipherType.equalsIgnoreCase("VOCALES")) {
            CipherType vocales = new Vocales();
            return new PreprocessDecorator(vocales);
        }

        return null;
    }
}
