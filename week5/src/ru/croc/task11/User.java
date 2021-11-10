package ru.croc.task11;

import java.time.LocalDateTime;

public class User extends Thread{
    private String name;

    private double currentBid = -1;

    private Lot lot;

    public User(String name, Lot lot) {
        this.name = name;
        this.lot = lot;
    }

    @Override
    public void run() {
        while (!lot.isInterrupted()) {
            try {
                synchronized (lot) {
                    if (LocalDateTime.now().isBefore(lot.getEndOfAuction()) && currentBid < lot.getCurrentPrice()) {
                        lot.setCurrentPriceAndName(lot.getCurrentPrice() + 5, name);
                        currentBid = lot.getCurrentPrice() +  5;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
