package se.kth.iv1350.amazingpos.model;
/**
 * A interface that implements the observer pattern, this interface notifies
 * any class that has implemented this interface if it is also added 
 * to {@link se.kth.iv1350.amazingpos.controller.Controller#addSaleObserver(SaleObserver)} 
 */
public interface SaleObserver {
    /**
     * Invoked when a Sale has been paid
     * @param totalPrice The total price of the sale
     */
    void newSale(double totalPrice);
}
