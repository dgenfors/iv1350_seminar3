package se.kth.iv1350.amazingpos.integration;

public class ExternalInventorySystem {
    private ItemDTO item;
    public ExternalInventorySystem(){
        this.item = new ItemDTO();
    }
    public ItemDTO getItemDescription(int itemID){
        return this.item;
    }
}
