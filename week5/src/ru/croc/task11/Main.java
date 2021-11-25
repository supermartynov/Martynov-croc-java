package ru.croc.task11;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lot lot = new Lot(LocalDateTime.now().plusSeconds(1));
        User user1 = new User("Danya", lot);
        User user2 = new User("Lexa", lot);
        User user3 = new User("John", lot);
        User user4 = new User("Petya",lot);
        User user5 = new User("Katya",lot);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        Thread.sleep(2000);
        System.out.println(lot.getWinnerName());

    }
}