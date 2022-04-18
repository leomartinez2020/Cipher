package com.example.demo;

import com.example.cipher.CipherTemplate;
import com.example.factory.CipherFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FactoryPatternDemo {
    public static String getMessageFromFile(String filePath) throws FileNotFoundException {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj, "windows-1252");
            String data = myReader.nextLine();
            System.out.println(data);
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in, "windows-1252");
        String filePath;
        //int key = 0;
        System.out.println("Ingrese la ruta del archivo:");
        filePath = sc.nextLine();
        System.out.println("Archivo a leer: " + filePath);
        String texto = getMessageFromFile(filePath);
        int corte = texto.indexOf('-');
        String tipoCodificacion = texto.substring(0, corte);
        String message = texto.substring(corte + 1);

        CipherFactory cipherFactory = new CipherFactory();
        String msg;
        switch (tipoCodificacion) {
            case "cesar":
                CipherTemplate cesar = cipherFactory.getCipher("CESAR");
                msg = cesar.encrypt(message);
                System.out.println(msg);
                cesar.writeEncryptedMessageToFile(msg, "cesar");
                break;
            case "invertido":
                CipherTemplate invertido = cipherFactory.getCipher("INVERTIDO");
                msg = invertido.encrypt(message);
                System.out.println(msg);
                invertido.writeEncryptedMessageToFile(msg, "invertido");
                break;
            case "vocales":
                CipherTemplate vocales = cipherFactory.getCipher("VOCALES");
                msg = vocales.encrypt(message);
                System.out.println(msg);
                vocales.writeEncryptedMessageToFile(msg, "vocales");
                break;
            default:
                // code block
        }

        //obtener objeto de cifrado cesar
        CipherTemplate cipher1 = cipherFactory.getCipher("CESAR");

        //cifrar con método cesar
        System.out.println(cipher1.encrypt("cesar-mary had a little lamb"));

        //obtener objeto de cifrado invertido
        CipherTemplate cipher2 = cipherFactory.getCipher("INVERTIDO");

        //cifrar con método invertido
        System.out.println(cipher2.encrypt("invertido-mary had a little lamb"));

        //obtener objeto de cifrado vocales
        CipherTemplate cipher3 = cipherFactory.getCipher("VOCALES");

        //cifrar con método vocales
        System.out.println(cipher3.encrypt("vocales-mary had a little lamb"));
    }
}
