package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.integration.Printer;

public class Sale {
    private Printer pntr;
    private Payment payment;
    private double runingTotal;
    private List<SoldItem> soldItems = new ArrayList<>();
    public Sale(){
        this.pntr = new Printer();
        this.payment = new Payment();
        this.runingTotal = 0;
    }
    public CurItem additem(ItemDTO item, int quantity){
        boolean foundItem = false;
        for(int i = 0; i<soldItems.size(); i++){
            SoldItem soldItem = soldItems.get(i);
            if(soldItem.getItem() == item){
                soldItem.incrementQuantity(quantity);
                soldItems.set(i, soldItem);
                foundItem = true;
            }
        }
        if(!foundItem){
            soldItems.add(new SoldItem(item, quantity));
        }
        
        increaseRuningTotal(item);
        return new CurItem(item, this.runingTotal);
    }
    public double getPrice(){
        return this.runingTotal;
    }
    public double pay(double amount){
        double change = calcChange(amount);
        Receipt receipt = new Receipt(this, change, amount);
        return change;
    }
    private double calcChange(double amountPaid){
        return this.runingTotal-amountPaid;
    }
    private void increaseRuningTotal(ItemDTO item){
        this.runingTotal =+payment.addVatRate(item);
    }
}
