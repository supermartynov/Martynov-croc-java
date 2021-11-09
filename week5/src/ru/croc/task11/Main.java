package ru.croc.task11;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lot lot = new Lot(LocalDateTime.parse("2021-11-10T00:58:40"));
        User user1 = new User("Danya");
        User user2 = new User("Lexa");
        User user3 = new User("John");
        User user4 = new User("Petya");
        User user5 = new User("Katya");

        lot.start();
        Thread.sleep(100);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();

    }
}
