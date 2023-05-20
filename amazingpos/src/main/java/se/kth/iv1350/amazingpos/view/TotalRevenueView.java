package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private double totalPrice;
    @Override
    public void newSale(double totalPrice){
        this.totalPrice += totalPrice;
        System.out.println("Sum of all sales:"+ this.totalPrice);
    }

}
