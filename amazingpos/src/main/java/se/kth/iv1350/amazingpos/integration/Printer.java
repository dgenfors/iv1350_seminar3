package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Receipt;

public class Printer {
    public void printSale(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
