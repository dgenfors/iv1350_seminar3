package se.kth.iv1350.amazingpos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.model.Sale;

public class ExternalInventorySystem {
    private List<ItemDTO> items = new ArrayList<>();

    public ExternalInventorySystem(){
        addItems();
    }
    public ItemDTO getItemDescription(int itemID){
        for(ItemDTO item : items){
            if(item.getItemID() == itemID){
                return item;
            }
        }
        return null;
    }
    public void updateInventory(Sale sale){

    }
    public void addItems(){
        items.add(new ItemDTO(50, 25, "lätt mjölk", 1));
        items.add(new ItemDTO(25, 12, "banan", 2));
        items.add(new ItemDTO(100, 6, "nötfärs", 3));
    }
}
