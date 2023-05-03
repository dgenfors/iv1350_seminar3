package se.kth.iv1350.amazingpos.model;


/*
 * Represents a receipt of a sale
 */
public class Receipt {
    private double change;
    private double amountPaid;
    private Sale sale;
    private TimeOfSale timeOfSale;
    /**
     * Creates a instance containing a Sale and the amount paid
     * and change of the sale. Also sets the data and time of the sale
     * @param sale to be presented by the new instance
     * @param change The change to be given after payment
     * @param amountPaid the amount Paid by the user
     */
    public Receipt(Sale sale, double change, double amountPaid){
        this.change = change;
        this.amountPaid = amountPaid;
        this.sale = sale;
        this.timeOfSale = new TimeOfSale();
        
    }
    /**
     * 
     * @return the Change in the Receipt
     */
    public double getChange(){
        return this.change;
    }
    /**
     * 
     * @return the amount Paid in the Receipt
     */
    public double getAmountPaid(){
        return this.amountPaid;
    }
    
    @Override
    /**
     * Creates a string For the Receipt
     * @return a String for the receipt 
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Date:" +timeOfSale.getSaleDate()+","+"Time:"+timeOfSale.getSaleTime()+"\n");
        for(SoldItem solditem : sale.getSoldItems()){
            builder.append(solditem.getItem().getItemDesc()+","+solditem.getItem().getPrice()+","+"Quantity:"+solditem.getQuantity() +"\n" );
        }
        builder.append("Totala Priset:"+ sale.getPriceWithVat()+"\n");
        builder.append("Vat:"+(sale.getPriceWithVat()-sale.getPriceWithoutVat())+"\n");
        builder.append("Amount paid:" +amountPaid+",");
        builder.append("Change:" +change);
        
        return builder.toString();
    }
}
