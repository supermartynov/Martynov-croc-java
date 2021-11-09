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
        System.out.println(winnerName + " : " + currentPrice);
        this.interrupt();
    }

    public void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        if (price > currentPrice || LocalDateTime.now().isBefore(endOfAuctionTime)) {
            currentPrice = price;
            Thread.sleep(100);
            winnerName = name;
            System.out.println(name + " поставил ставку: " + price);
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public void setEndOfAuction(LocalDateTime endOfAuction) {
        endOfAuctionTime = endOfAuction;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }
}
