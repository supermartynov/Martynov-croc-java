package ru.croc.task8;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String txt = "week4/src/ru/croc/task8/text.txt";

        int counter = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(txt));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            line = line.replaceAll("\\p{Punct}", "");
            String after = line.trim().replaceAll(" +", " ");
            counter = counter + after.split(" ").length;
        }
        System.out.println(counter);
    }
}
