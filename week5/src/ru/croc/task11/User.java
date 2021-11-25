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
        while (LocalDateTime.now().isBefore(lot.getEndOfAuction())) {
            try {
                {
                    {
                        lot.setCurrentPriceAndName(lot.getCurrentBid() + 5, name);
                        currentBid = lot.getCurrentBid() +  5;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}