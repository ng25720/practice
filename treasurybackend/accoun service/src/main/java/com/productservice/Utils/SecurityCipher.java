package com.productservice.Utils;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SecurityCipher {
    private static final String KEYVALUE = "secureCDCKey";
    private static SecretKeySpec secretKey;
    private static byte[] key;



    private SecurityCipher() {
        throw new AssertionError("Static!");
    }


    public static void setKey() {
        MessageDigest sha;
        try {
            key = KEYVALUE.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
