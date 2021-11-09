package ru.croc.task11;

import java.time.LocalDateTime;

public class Lot extends Thread{

    private volatile static Double currentPrice = 0.0;

    private volatile static String winnerName = "Никто не выиграл";

    private volatile static LocalDateTime endOfAuctionTime;

    public Lot(LocalDateTime endOfAuctionTime) {
        Lot.endOfAuctionTime = endOfAuctionTime;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(endOfAuctionTime)) {

        }
        System.out.println(winnerName + " : " + currentPrice);
    }

    public static synchronized void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        if (price > currentPrice || LocalDateTime.now().isBefore(endOfAuctionTime)) {
            Lot.currentPrice = price;
            Thread.sleep(500);
            Lot.winnerName = name;
            System.out.println(name + " поставил ставку: " + price);
        }
    }

    public static LocalDateTime getEndOfAuction() {
        return Lot.endOfAuctionTime;
    }

    public static void setEndOfAuction(LocalDateTime endOfAuction) {
        Lot.endOfAuctionTime = endOfAuction;
    }

    public static Double getCurrentPrice() {
        synchronized (currentPrice) {
            return currentPrice;
        }
    }
}
