package se.kth.iv1350.amazingpos.view;

import java.io.IOException;

import se.kth.iv1350.amazingpos.model.SaleObserver;
import se.kth.iv1350.amazingpos.util.LogHandler;
/**
 * Writes out the total sum of sale to file under name; amazingpos-SaleLog.txt
 */
public class TotalRevenueFileOutput implements SaleObserver   {
    private double totalPrice;
    private int amountOfSales;
    private static LogHandler loghandler;
    public TotalRevenueFileOutput() throws IOException{
         loghandler = new LogHandler("amazingpos-SaleLog.txt");
    }
    @Override
    public void newSale(double totalPrice){
        this.totalPrice += totalPrice;
        amountOfSales++;
        loghandler.logDouble(amountOfSales,this.totalPrice);
    }
}
