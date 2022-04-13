package com.example.demo;

import com.example.cipher.CipherType;
import com.example.factory.CipherFactory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in, "windows-1252");
        //String message;
        //int key = 0;
        //System.out.println("Ingrese el mensaje a encriptar:");
        //message = sc.nextLine();
        //System.out.println("Mensaje encriptado:" + encrypt13(message));

        CipherFactory cipherFactory = new CipherFactory();

        //obtener objeto de cifrado cesar
        CipherType cipher1 = cipherFactory.getCipher("CESAR");

        //cifrar con método cesar
        System.out.println(cipher1.encrypt("cesar-mary had a little lamb"));

        //obtener objeto de cifrado invertido
        CipherType cipher2 = cipherFactory.getCipher("INVERTIDO");

        //cifrar con método invertido
        System.out.println(cipher2.encrypt("invertido-mary had a little lamb"));

        //obtener objeto de cifrado vocales
        CipherType cipher3 = cipherFactory.getCipher("VOCALES");

        //cifrar con método vocales
        System.out.println(cipher3.encrypt("vocales-mary had a little lamb"));
    }
}
