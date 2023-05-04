package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
/**
 * Represents a instance of a SoldItem
 */
public class SoldItem {
    private ItemDTO item;
    private int quantity;
    /**
     * creates a instance of the object with the sold item and amount bought
     * @param item A sold item
     * @param quantity  The amount bought of the item.
     */
    public SoldItem(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    /**
     * Get the sold item
     * @return The sold item
     */
    public ItemDTO getItem(){
        return this.item;
    }
    /**
     * get the quantity of the sold item
     * @return The quantity of the sold item.
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Increases the quantity of the sold item.
     * @param quantity The quantity to increment the amount of sold items.
     */
    public void incrementQuantity(int quantity){
        this.quantity += quantity;
    }
}
