package se.kth.iv1350.amazingpos.model;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Represents a time and date
 */
public class TimeOfSale {
    private LocalTime saleTime;
    private LocalDate saleDate;
    /**
     * Creates a instance of the object and 
     * saves the local time and data into the instance
     */
    public TimeOfSale(){
        this.saleTime = LocalTime.now();
        this.saleDate = LocalDate.now();
        
    }
    /**
     * Get the time of sale
     * @return the Time of sale
     */
    public LocalTime getSaleTime(){
        return this.saleTime;
    }
    /**
     * Get the date of sale
     * @return The date of the sale
     */
    public LocalDate getSaleDate(){
        return this.saleDate;
    }
}
