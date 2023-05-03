package se.kth.iv1350.amazingpos.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.model.Sale;
/**
 * Represenets the external invetory system
 */
public class ExternalInventorySystem {
    private List<ItemDTO> items = new ArrayList<>();
    /**
     * Creates a list of items
     */
    public ExternalInventorySystem(){
        addItems();
    }
    /**
     * Gets the ItemDescription for the item matching 
     * the specified ID
     * @param itemID the ItemID used to find the matching Item
     * @return the item description of the item matching the ID
     */
    public ItemDTO getItemDescription(int itemID){
        for(ItemDTO item : items){
            if(item.getItemID() == itemID){
                return item;
            }
        }
        return null;
    }
    /**
     * Updates the inventory with information from the sale
     * @param sale stores the information to be used to update the inventory.
     */
    public void updateInventory(Sale sale){

    }

    private void addItems(){
        items.add(new ItemDTO(50, 0.25, "lätt mjölk", 1));
        items.add(new ItemDTO(25, 0.12, "banan", 2));
        items.add(new ItemDTO(100, 0.06, "nötfärs", 3));
        items.add(new ItemDTO(30, 0.06, "kyckling", 4));
    }
}
