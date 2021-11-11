package ru.croc.task12;

public class Executor extends Thread{

    String currentWord;

    char[] charArray;

    private static final char[] CHOICES = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    @Override
    public void run() {
        for (int i = 0; i < charArray.length; i++) {
            if (BrutForce.password.length() != 0) {
                return;
            }
            BrutForce.brutForce(currentWord + charArray[i], CHOICES);
        }
    }

    public Executor(String currentWord, char[] charArray) {
        this.currentWord = currentWord;
        this.charArray = charArray;
    }
}
