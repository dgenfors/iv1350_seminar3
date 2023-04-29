package se.kth.iv1350.amazingpos.integration;

public class ItemDTO {
    private double price;
    private int vatRate;
    private String itemDesc;

    public double getPrice(){
        return this.price;
    }
    public int getVatRate(){
        return this.vatRate;
    }
    public String getItemDesc(){
        return this.itemDesc;
    }
}
