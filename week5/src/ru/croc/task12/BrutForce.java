package ru.croc.task12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BrutForce {

    public static String trueHex = "40682260CC011947FC2D0B1A927138C5";

    public static String hex = "";

    public static String password = "";

    public static Integer threadsAmount = 0;

    private static final char[] CHOICES = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static List<List<Character>> arrayOfArrays = new ArrayList<>();

    public static void divideArrays(int threadsAmount) {
        int chunkSize = 26 / threadsAmount;

        int counter = 0;
        List<Character> subArray = new ArrayList<>();
        for (int i = 0; i < (26 - 26 % threadsAmount); i++) {
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
        for (int i = 0; i < 26 % threadsAmount; i++) {
            arrayOfArrays.get(i % arrayOfArrays.size()).add(CHOICES[25 - i]);
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


    public static void brutForce (String currentString) {
        if (password.length() != 0) {
            Thread.currentThread().interrupt();
            return;
        }

        if (currentString.length() == 7) {
            if (Hex.hashPassword(currentString).equals(trueHex)) {
                System.out.println(LocalDateTime.now());
                System.out.println(currentString);
                hex = Hex.hashPassword(currentString);
                password = currentString;
            }
            return;
        }

        if (currentString.length() == 1){
            for (int i = 0; i < arrayOfArrays.size(); i++) {
                char[] currentCharArray = CharacterListToCharArray(arrayOfArrays.get(i));
                new Executor(currentString, currentCharArray).start();
            }
        } else {
            for (char letter : CHOICES) {
                brutForce(currentString + letter);
            }
        }
    }

    public static void main(String[] args) {
        if (Integer.parseInt(args[0]) > 26) {
            threadsAmount = 26;
            System.out.println("Максимальное количество потоков - 26. Сделал 26");
        } else {
            threadsAmount = Integer.parseInt(args[0]);
        }
        //threadsAmount = 4
        divideArrays(threadsAmount);
        System.out.println(LocalDateTime.now());
        brutForce("");
    }

}
