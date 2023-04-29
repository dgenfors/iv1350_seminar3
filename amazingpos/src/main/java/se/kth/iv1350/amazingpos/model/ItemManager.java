package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;
import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class ItemManager{
    private ExternalInventorySystem exInSys;
    private Sale sale;
 public ItemManager(ExternalInventorySystem exInSys, Sale sale){
    this.exInSys = exInSys;
    this.sale = sale;
 }
 public CurItem geItem(int quantity, int itemID){
   ItemDTO item = exInSys.getItemDescription(itemID);
   return sale.additem(item,quantity);
 }
}