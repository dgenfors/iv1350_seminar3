package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.SaleObserver;
/**
 * Writes out the total sum of sale to console
 */
public class TotalRevenueView implements SaleObserver {
    private double totalPrice;
    private int amountOfSales;
    @Override
    public void newSale(double totalPrice){
        this.totalPrice += totalPrice;
        this.amountOfSales++;
        System.out.println("Amount of Sales:"+amountOfSales+", Sum of all sales:"+ this.totalPrice);
    }

}
