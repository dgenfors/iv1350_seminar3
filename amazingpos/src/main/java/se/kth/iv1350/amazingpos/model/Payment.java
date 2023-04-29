package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;

public class Payment {
    private double priceVatIncl;

    public double addVatRate(ItemDTO item){
        return this.priceVatIncl;
    }
}