package se.kth.iv1350.amazingpos.integration;
/*
 * Represents a item in the store.
 */
public class ItemDTO {
    private double price;
    private double vatRate;
    private String itemDesc;
    private int itemID;

    /**
     * Creates a new instance represeting a Item with the specified parameters.
     * @param price of the item
     * @param vatRate of the item
     * @param itemDesc describes the item
     * @param itemID    Identifier for the item
     */
    public ItemDTO(double price, double vatRate, String itemDesc, int itemID){
        this.price = price;
        this.vatRate = vatRate;
        this.itemDesc = itemDesc;
        this.itemID = itemID;

    }
    
    /** 
     * @return The price of the Item
     */
    public double getPrice(){
        return this.price;
    }
    /** 
     * @return The VatRate of the item
     */
    public double getVatRate(){
        return this.vatRate;
    }
     /** 
     * @return The description of the item
     */
    public String getItemDesc(){
        return this.itemDesc;
    }
     /** 
     * @return The ItemID of the item
     */
    public int getItemID(){
        return this.itemID;
    }
}
