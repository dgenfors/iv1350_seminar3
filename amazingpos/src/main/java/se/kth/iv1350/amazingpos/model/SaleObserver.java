package se.kth.iv1350.amazingpos.model;

public interface SaleObserver {
    /**
     * Invoked when a Sale has been paid
     */
    void newSale(double totalPrice);
}
