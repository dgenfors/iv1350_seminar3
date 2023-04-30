package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.integration.Printer;

public class Sale {
    private Printer pntr;
    private Payment payment;
    private double runingTotal;
    public Sale(){
        this.pntr = new Printer();
        this.payment = new Payment();
    }
    public CurItem additem(ItemDTO item, int quantity){
        this.runingTotal =+payment.addVatRate(item);
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
}
