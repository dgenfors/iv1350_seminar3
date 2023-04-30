package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class SoldItem {
    private ItemDTO item;
    private int quantity;
    public SoldItem(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public ItemDTO getItem(){
        return this.item;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void incrementQuantity(int quantity){
        this.quantity =+ quantity;
    }
}
