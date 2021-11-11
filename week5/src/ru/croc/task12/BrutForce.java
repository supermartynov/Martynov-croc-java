package ru.croc.task12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class BrutForce {

    public static String trueHex = "40682260CC011947FC2D0B1A927138C5";

    public static String hex = "";

    public static String password = "";

    public static Integer counter = 0;

    private static final char[] CHOICES = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }


    public static void brutForce (String currentString) {
        if (password.length() != 0) {
            return;
        }

        if (currentString.length() == 7) {
            if (hashPassword(currentString).equals(trueHex)) {
                hex = hashPassword(currentString);
                password = currentString;
            }
            return;
        }

        for (char letter : CHOICES) {
            brutForce(currentString + letter);
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        brutForce("");
        System.out.println((System.currentTimeMillis() - time)/1000);
    }

}
