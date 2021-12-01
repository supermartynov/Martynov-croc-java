package ru.croc.task19;

import java.io.*;

public class Main {

    public final static String filePath = "./week8/src/ru/croc/task19/output.txt";

    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println("Введите что-нибудь для записи в текстовый файл");
            String text = bufferedReader.readLine();
            fileWriter.write(text);
        }
    }
}
