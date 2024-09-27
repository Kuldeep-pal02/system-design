package com.lucene.handson.common;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomStringGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 5;
    private static final Random random = new Random();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(STRING_LENGTH);

        sb.append(System.currentTimeMillis());
        for (int i = 0; i < STRING_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());

            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }
}

