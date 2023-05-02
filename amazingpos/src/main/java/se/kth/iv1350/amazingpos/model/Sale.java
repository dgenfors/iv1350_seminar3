package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.integration.Printer;

public class Sale {
    private Printer pntr;
    private Payment payment;
    private double runingTotal;
    private double priceWithoutVat;
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
        this.priceWithoutVat += item.getPrice()*quantity;
        increaseRuningTotal(item, quantity);
        return new CurItem(item, this.runingTotal);
    }
    public double getPriceWithVat(){
        return this.runingTotal;
    }
    public List<SoldItem> getSoldItems(){
        return this.soldItems;
    }
    public double getPriceWithoutVat(){
        return this.priceWithoutVat;
    }
    public double pay(double amountPaid){
        double change = payment.calcChange(amountPaid, this.runingTotal);
        Receipt receipt = new Receipt(this, change, amountPaid);
        pntr.printSale(receipt);
        return change;
    }

    private void increaseRuningTotal(ItemDTO item, int quantity){
        this.runingTotal +=(payment.addVatRate(item)*quantity);
    }
}
