package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class CurItem {
    private ItemDTO item;
    private double runingTotal;
    /*Creates an object containing a item and the runingTotal for the current sale to be returned and displayed by View */
    public CurItem(ItemDTO item, double runingTotal){
        this.item = item;
        this.runingTotal = runingTotal;
    }
    public double getRuningTotal(){
        return this.runingTotal;
    }
    public String getItemDesc(){
        return this.item.getItemDesc();
    }
}
