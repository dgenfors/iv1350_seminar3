package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Receipt;

public class Printer {

    
    /** 
     * Prints the receipt out to the console
     * @param receipt receipt to be printed
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
