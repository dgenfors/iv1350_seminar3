package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Sale;

public class ExternalInventorySystem {
    private ItemDTO item;
    public ExternalInventorySystem(){
        this.item = new ItemDTO();
    }
    public ItemDTO getItemDescription(int itemID){
        return this.item;
    }
    public void updateInventory(Sale sale){

    }
}
