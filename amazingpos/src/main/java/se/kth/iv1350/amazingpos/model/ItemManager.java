package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;

public class ItemManager{
    private ExternalInventorySystem exInSys;
 public ItemManager(ExternalInventorySystem exInSys){
    this.exInSys = exInSys;
 }
}