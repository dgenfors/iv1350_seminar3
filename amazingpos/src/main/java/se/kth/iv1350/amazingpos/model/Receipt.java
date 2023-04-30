package se.kth.iv1350.amazingpos.model;



public class Receipt {
    private double change;
    private double amountPaid;
    private Sale sale;
    private TimeOfSale timeOfSale;
    
    public Receipt(Sale sale, double change, double amountPaid){
        this.change = change;
        this.amountPaid = amountPaid;
        this.sale = sale;
        this.timeOfSale = new TimeOfSale();
        
    }
    public double getChange(){
        return this.change;
    }
    public double getAmountPaid(){
        return this.amountPaid;
    }
}
