package ru.croc.task11;

import java.time.LocalDateTime;

public class User extends Thread{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(Lot.getEndOfAuction())) {
            try {
                Lot.setCurrentPriceAndName(Lot.getCurrentPrice() + 5, name);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
