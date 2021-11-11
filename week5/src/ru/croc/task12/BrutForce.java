package ru.croc.task12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BrutForce {

    public static String trueHex = "40682260CC011947FC2D0B1A927138C5";

    public static String hex = "";

    public static String password = "";

    public static Integer threadsAmount = 0;

    public static Integer counter = 0;

    private static final char[] CHOICES = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static List<List<Character>> arrayOfArrays = new ArrayList<>();

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

    public static void divideArrays(int threadsAmount) {
        int chunkSize = 26 / threadsAmount;
        int counter = 0;
        List<Character> subArray = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (counter != chunkSize) {
                subArray.add(CHOICES[i]);
                counter++;
            } else {
                arrayOfArrays.add(subArray);
                subArray = new ArrayList<Character>();
                subArray.add(CHOICES[i]);
                counter = 1;
            }
        }
        arrayOfArrays.add(subArray);
    }

    public static char[] CharacterListToCharArray(List<Character> characters) {
        char[] newChar = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            newChar[i] = characters.get(i);
        }
        return newChar;
    }


    public static void brutForce (String currentString, char[] characters) {
        if (password.length() != 0) {
            Thread.currentThread().interrupt();
            return;
        }

        if (currentString.length() == 7) {
            if (hashPassword(currentString).equals(trueHex)) {
                System.out.println(LocalDateTime.now());
                System.out.println(currentString);
                hex = hashPassword(currentString);
                password = currentString;
            }
            return;
        }

        if (currentString.length() == 1){
            for (int i = 0; i < arrayOfArrays.size(); i++) {
                char[] currentCharArray = CharacterListToCharArray(arrayOfArrays.get(i));
                new Executor(currentString , currentCharArray).start();
            }
        } else {
            for (char letter : characters) {
                brutForce(currentString + letter, characters);
            }
        }
    }

    public static void main(String[] args) {
        threadsAmount = Integer.parseInt(args[0]);
        divideArrays(threadsAmount);
        System.out.println(LocalDateTime.now());
        brutForce("", CHOICES);
    }

}
