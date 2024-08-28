package com.natanxds.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class CryptographyService {

    private static final StrongTextEncryptor strongTextEncryptor;

    static {
        strongTextEncryptor = new StrongTextEncryptor();
        strongTextEncryptor.setPassword(System.getenv("APP_KEY"));
    }

    public static String encrypt(String rawText) {
        return strongTextEncryptor.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return strongTextEncryptor.decrypt(encryptedText);
    }
}
