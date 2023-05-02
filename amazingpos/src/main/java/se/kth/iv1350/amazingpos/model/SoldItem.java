package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class SoldItem {
    private ItemDTO item;
    private int quantity;
    private double priceAfterVat;
    public SoldItem(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public void setPriceWithVat(double priceAfterVat){
        this.priceAfterVat = priceAfterVat;
    }
    public ItemDTO getItem(){
        return this.item;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void incrementQuantity(int quantity){
        this.quantity += quantity;
    }
}
