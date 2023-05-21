package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.integration.ItemDTO;
import se.kth.iv1350.amazingpos.integration.Printer;
/**
 * Represents a instance of a Sale.
 */
public class Sale {
    private Printer pntr;
    private Payment payment;
    private double runingTotal;
    private double priceWithoutVat;
    private List<SoldItem> soldItems = new ArrayList<>();
    private List<SaleObserver> saleObserver = new ArrayList<>();
    /**
     * Creates a instance of a sale
     */
    public Sale(){
        this.pntr = new Printer();
        this.payment = new Payment();
        this.runingTotal = 0;
    }
    /**
     * Adds the item and its quantity to the instance
     * @param item  The item to be added
     * @param quantity  The quantity of the item
     * @return the item and the current runingtotal of the Sale
     */
    public CurItem additem(ItemDTO item, int quantity){
        boolean foundItem = false;
        for(int i = 0; i<soldItems.size(); i++){
            SoldItem soldItem = soldItems.get(i);
            if(soldItem.getItem() == item){
                soldItem.incrementQuantity(quantity);
                soldItems.set(i, soldItem);
                foundItem = true;
            }
        }
        if(!foundItem){
            soldItems.add(new SoldItem(item, quantity));
        }
        this.priceWithoutVat += item.getPrice()*quantity;
        increaseRuningTotal(item, quantity);
        return new CurItem(item, this.runingTotal);
    }
    /**
     * Get the Price with vat included
     * @return The price of the sale with Vat included
     */
    public double getPriceWithVat(){
        return this.runingTotal;
    }
    /**
     * Get the list of sold items in the sale
     * @return The list of sold Items in the sale
     */
    public List<SoldItem> getSoldItems(){
        return this.soldItems;
    }
    /**
     * get the Price without vat included
     * @return The Price of the sale without Vat.
     */
    public double getPriceWithoutVat(){
        return this.priceWithoutVat;
    }
    /**
     * Calculates the change to be given and creates a receipt object which 
     * is then sent to Printer to be used there
     *
     * @param amountPaid The amountPaid by the customer.
     * @return The change to be given.
     */
    public double pay(double amountPaid){
        double change = payment.calcChange(amountPaid, this.runingTotal);
        Receipt receipt = new Receipt(this, change, amountPaid);
        pntr.printReceipt(receipt);
        notifyObservers();
        return change;
    }
    /**
     * Adds the specified observers to be notifed when the Sale is paid for.
     * @param observers the observers to notify
     */
    public void addObserver(List<SaleObserver> observers){
        saleObserver.addAll(observers);
    }

    private void increaseRuningTotal(ItemDTO item, int quantity){
        this.runingTotal +=(payment.addVatRate(item)*quantity);
    }
    private void notifyObservers(){
        saleObserver.stream().forEach(obs -> obs.newSale(runingTotal));
    }
}
