package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.SaleObserver;
/**
 * Writes out the total sum of sale to console
 */
public class TotalRevenueView implements SaleObserver {
    private double totalPrice;
    @Override
    public void newSale(double totalPrice){
        this.totalPrice += totalPrice;
        System.out.println("Sum of all sales:"+ this.totalPrice);
    }

}
