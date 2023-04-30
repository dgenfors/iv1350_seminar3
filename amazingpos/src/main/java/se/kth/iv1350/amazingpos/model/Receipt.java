package se.kth.iv1350.amazingpos.model;

public class Receipt {
    private double change;
    private double amountPaid;
    private Sale sale;
    public Receipt(Sale sale, double change, double amountPaid){
        this.change = change;
        this.amountPaid = amountPaid;
        this.sale = sale;
    }
    public double getChange(){
        return this.change;
    }
    public double getAmountPaid(){
        return this.amountPaid;
    }
}
