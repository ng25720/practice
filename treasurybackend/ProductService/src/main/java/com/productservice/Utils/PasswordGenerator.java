package com.productservice.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@Slf4j

public class PasswordGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String CHARACTERS = "!@#$%&*ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generates a random password using a specified length.
     *
     * @param length The length of the password.
     * @return A random password as a String.
     */
    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        log.info("Password generated successfully", password);
        return password.toString();
    }

}
