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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(SoldItem solditem : sale.getSoldItems()){
            builder.append(solditem.getItem().getItemDesc()+","+solditem.getItem().getPrice()+","+"Quantity:"+solditem.getQuantity() +"\n" );
        }
        builder.append("Totala Priset:"+ sale.getPriceWithVat()+"\n");
        builder.append("Vat:"+(sale.getPriceWithVat()-sale.getPriceWithoutVat()));
        
        return builder.toString();
    }
}
