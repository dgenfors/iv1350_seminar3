package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
/*
 * Represents a instance to be used to calcualte VatRate
 * And change for the sale.
 */
public class Payment {
    /**
     * Takes the vatRate and price of a item to
     * return the price with them combined
     * @param item to be used in the calculation
     * @return the price with vatIncluded of the item.
     */
    public double addVatRate(ItemDTO item){
        double itemVatRate = item.getVatRate();
        double priceWithVat = (item.getPrice()*itemVatRate)+item.getPrice();
        return priceWithVat;
    }
    /**
     * Subtracts the runingtotal from amountpaid to get the change to be paid.
     * @param amountPaid the amountpaid for the sale
     * @param runingTotal the runingTotal/TotalPrice of the sale
     * @return the change to be given.
     */
    public double calcChange(double amountPaid, double runingTotal){
       return amountPaid-runingTotal;
    }
}