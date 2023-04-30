package se.kth.iv1350.amazingpos.integration;

public class ItemDTO {
    private double price;
    private double vatRate;
    private String itemDesc;
    private int itemID;

    public ItemDTO(double price, double vatRate, String itemDesc, int itemID){
        this.price = price;
        this.vatRate = vatRate;
        this.itemDesc = itemDesc;
        this.itemID = itemID;

    }
    public double getPrice(){
        return this.price;
    }
    public double getVatRate(){
        return this.vatRate;
    }
    public String getItemDesc(){
        return this.itemDesc;
    }
    public int getItemID(){
        return this.itemID;
    }
}
