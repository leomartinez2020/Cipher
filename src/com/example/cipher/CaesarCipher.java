package com.example.cipher;

import java.util.Scanner;

public class CaesarCipher { //to keep track of index
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt13(String message) {
        int shiftKey = 13;
        int corte = message.indexOf('-');
        message = message.substring(corte + 1);
        message = message.toLowerCase();
        StringBuilder cipherText = new StringBuilder();
        for (int ii = 0; ii < message.length(); ii++) {
            if (message.charAt(ii) == ' ') {
                cipherText.append(' ');
                continue;
            }
            int charPosition = alpha.indexOf(message.charAt(ii));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = alpha.charAt(keyVal);
            cipherText.append(replaceVal);
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "windows-1252");
        String message;
        int key = 0;
        System.out.println("Ingrese el mensaje a encriptar:");
        message = sc.nextLine();
        System.out.println("Mensaje encriptado:" + encrypt13(message));
    }
}
