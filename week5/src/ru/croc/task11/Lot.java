package ru.croc.task11;

import java.time.LocalDateTime;

public class Lot{

    private volatile Double currentBid = 0.0;

    private volatile String winnerName;

    private LocalDateTime endOfAuctionTime;

    public Lot(LocalDateTime endOfAuctionTime) {
        this.endOfAuctionTime = endOfAuctionTime;
    }

    public void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        if (price > currentBid || LocalDateTime.now().isBefore(endOfAuctionTime)) {
            synchronized (currentBid) {
                if (price > currentBid || LocalDateTime.now().isBefore(endOfAuctionTime)) {
                    currentBid = price;
                    winnerName = name;
                    System.out.println(name + " поставил ставку: " + price);
                }
            }
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public synchronized Double getCurrentBid() {
        return currentBid;
    }

    public synchronized String getWinnerName() {
        if (LocalDateTime.now().isBefore(endOfAuctionTime)) {
            return null;
        }
        return winnerName;
    }
}