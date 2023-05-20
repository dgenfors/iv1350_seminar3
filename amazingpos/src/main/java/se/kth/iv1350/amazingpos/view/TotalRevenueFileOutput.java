package se.kth.iv1350.amazingpos.view;

import java.io.IOException;

import se.kth.iv1350.amazingpos.model.SaleObserver;
import se.kth.iv1350.amazingpos.util.LogHandler;

public class TotalRevenueFileOutput implements SaleObserver   {
    private double totalPrice;
    private static LogHandler loghandler;
    public TotalRevenueFileOutput() throws IOException{
         loghandler = new LogHandler("amazingpos-SaleLog.txt");
    }
    @Override
    public void newSale(double totalPrice){
        this.totalPrice += totalPrice;
        loghandler.logDouble(this.totalPrice);
        
    }
}