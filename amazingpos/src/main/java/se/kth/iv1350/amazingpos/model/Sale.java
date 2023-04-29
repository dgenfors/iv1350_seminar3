package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.Printer;

public class Sale {
    private Printer pntr;
    private Payment payment;
    public Sale(){
        this.pntr = new Printer();
        this.payment = new Payment();
    }
}
