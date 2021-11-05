package ru.croc.task8;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            line = line.replaceAll("\\p{Punct}", "");
            String after = line.trim().replaceAll(" +", " ");
            counter = counter + after.split(" ").length;
        }
        System.out.println(counter);
    }
}
