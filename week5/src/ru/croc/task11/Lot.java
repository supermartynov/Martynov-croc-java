package ru.croc.task11;

import java.time.LocalDateTime;

public class Lot extends Thread{

    private Double currentPrice = 0.0;

    private String winnerName = "Никто не выиграл";

    private LocalDateTime endOfAuctionTime;

    public Lot(LocalDateTime endOfAuctionTime) {
        this.endOfAuctionTime = endOfAuctionTime;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(endOfAuctionTime)) {

        }
        this.interrupt();
        System.out.println("Победитель - " +winnerName + " : " + currentPrice);
    }

    public synchronized void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        synchronized (currentPrice) {
            if (price > currentPrice || LocalDateTime.now().isBefore(endOfAuctionTime)) {
                currentPrice = price;
                synchronized (winnerName) {
                    winnerName = name;
                }
                System.out.println(name + " поставил ставку: " + price);
            }
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public synchronized Double getCurrentPrice() {
        return currentPrice;
    }
}
