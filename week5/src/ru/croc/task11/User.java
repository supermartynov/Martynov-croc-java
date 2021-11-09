package ru.croc.task11;

import java.time.LocalDateTime;

public class User extends Thread{
    private String name;

    private Lot lot;

    public User(String name, Lot lot) {
        this.name = name;
        this.lot = lot;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(lot.getEndOfAuction())) {
            try {
                synchronized (lot) {
                    if (!lot.isInterrupted()) {
                        lot.setCurrentPriceAndName(lot.getCurrentPrice() + 5, name);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
