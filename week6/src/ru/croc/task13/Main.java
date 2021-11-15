package ru.croc.task13;

import java.util.*;

public class Main {
    public static List<String> comments = new LinkedList<>();
    public static Set<String> badWords = new HashSet<>();

    static {
        comments.add("Дурак");
        comments.add("Отличный совет !");
        comments.add("Отличный совет ! Желаю удачи");
        comments.add("Отличный совет, идиот ! Теперь у меня будут проблемы");
        badWords.add("дурак");
        badWords.add("идиот");
    }

    public static void main(String[] args) {
        comments.forEach(System.out::println);
        new BlackListFilterImplementation().filterComments(comments, badWords);
        System.out.println("\nПосле удаления\n");
        comments.forEach(System.out::println);
    }
}
