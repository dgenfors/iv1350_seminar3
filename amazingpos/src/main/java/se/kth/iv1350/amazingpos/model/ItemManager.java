package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;
import se.kth.iv1350.amazingpos.integration.ItemDTO;
/**
 * Representer a itemmanager 
 */
public class ItemManager{
    private ExternalInventorySystem exInSys;
    private Sale sale;
    /**
     * Creates an instance with the objects to be used.
     * @param exInSys the reference to be used to get a item.
     * @param sale the sale to be used to store the item.
     */
 public ItemManager(ExternalInventorySystem exInSys, Sale sale){
    this.exInSys = exInSys;
    this.sale = sale;
 }
 public CurItem geItem(int quantity, int itemID){
   ItemDTO item = exInSys.getItemDescription(itemID);
   return sale.additem(item,quantity);
 }
}