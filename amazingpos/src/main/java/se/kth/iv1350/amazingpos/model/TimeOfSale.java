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
     * 
     * @return the Time of creation of the object
     */
    public LocalTime getSaleTime(){
        return this.saleTime;
    }
    /**
     * 
     * @return the data of creation of the object
     */
    public LocalDate getSaleDate(){
        return this.saleDate;
    }
}
