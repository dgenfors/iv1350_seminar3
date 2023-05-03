package se.kth.iv1350.amazingpos.integration;
/*
 * Represents the register in the store.
 */
public class Register {
    private double amountInRegister;
    
    /** 
     * Adds the amount in the object with the amountPaid.
     * @param amountPaid in the last sale
     */
    public void updateAmountInRegister(double amountPaid){
        this.amountInRegister += amountPaid;
    }
}
