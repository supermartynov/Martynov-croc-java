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

    public void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        if (price > currentPrice || LocalDateTime.now().isBefore(endOfAuctionTime)) {
            currentPrice = price;
            winnerName = name;
            System.out.println(name + " поставил ставку: " + price);
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }
}
