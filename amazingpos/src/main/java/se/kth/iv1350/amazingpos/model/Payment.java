package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class Payment {

    public double addVatRate(ItemDTO item){
        double itemVatRate = item.getVatRate();
        double priceWithVat = (item.getPrice()*itemVatRate)+item.getPrice();
        return priceWithVat;
    }
    public double calcChange(double amountPaid, double runingTotal){
       return amountPaid-runingTotal;
    }
}