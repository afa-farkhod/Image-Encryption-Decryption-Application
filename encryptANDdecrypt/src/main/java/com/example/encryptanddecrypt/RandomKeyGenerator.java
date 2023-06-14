package com.example.encryptanddecrypt;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomKeyGenerator {

    public static void main(String[] args) {

        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[16]; // AES 128-bit key length
        secureRandom.nextBytes(keyBytes);
        String sampleKey = Base64.getEncoder().encodeToString(keyBytes);

        System.out.println("Sample Key: " + sampleKey);
    }
}
