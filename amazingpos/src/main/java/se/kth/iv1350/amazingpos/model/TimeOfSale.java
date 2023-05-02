package se.kth.iv1350.amazingpos.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeOfSale {
    private LocalTime saleTime;
    private LocalDate saleDate;
    private int timeOfSale;
    public TimeOfSale(){
        this.saleTime = LocalTime.now();
        this.saleDate = LocalDate.now();
        
    }
    public LocalTime getSaleTime(){
        return this.saleTime;
    }
    public LocalDate getSaleDate(){
        return this.saleDate;
    }
}
