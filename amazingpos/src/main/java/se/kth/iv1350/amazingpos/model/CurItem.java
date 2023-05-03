package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
/*
 * Represents a item and the current runingTotal of a sale
 */
public class CurItem {
    private ItemDTO item;
    private double runingTotal;
    /*Creates an object containing a item and the runingTotal for the current sale to be returned and displayed by View */
    public CurItem(ItemDTO item, double runingTotal){
        this.item = item;
        this.runingTotal = runingTotal;
    }
    
    /** 
     * @return the runingtotal of this object.
     */
    public double getRuningTotal(){
        return this.runingTotal;
    }
    /**
     * @return The itemDescription of the item in this object.
     */
    public String getItemDesc(){
        return this.item.getItemDesc();
    }
    /**
     * 
     * @return The price of the item.
     */
    public double getItemPrice(){
        return this.item.getPrice();
    }
}
