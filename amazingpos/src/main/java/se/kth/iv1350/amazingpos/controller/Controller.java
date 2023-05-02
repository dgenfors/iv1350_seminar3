package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.AccountingSystem;
import se.kth.iv1350.amazingpos.integration.DiscountRegister;
import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;
import se.kth.iv1350.amazingpos.integration.Register;
import se.kth.iv1350.amazingpos.model.CurItem;
import se.kth.iv1350.amazingpos.model.ItemManager;
import se.kth.iv1350.amazingpos.model.Sale;

public class Controller {
    private ExternalInventorySystem exInSys;
    private DiscountRegister disReg;
    private AccountingSystem accSys;
    private Register register;
    private ItemManager itmMnger;
    private Sale sale;
    public Controller(){
        this.exInSys = new ExternalInventorySystem();
        this.disReg = new DiscountRegister();
        this.accSys = new AccountingSystem();
        this.register = new Register();
    }

    /*Starts a new sale, this method must be called before doing anything else in a sale */
    public void startSale(){
        this.sale = new Sale();
        this.itmMnger = new ItemManager(this.exInSys, this.sale);
        
    }
    public CurItem scanItem(int quantity, int itemID){
        return itmMnger.geItem(quantity, itemID);
    }
    public double endSale(){
        return sale.getPriceWithVat();
    }
    public double payment(double amountPaid){
        updateExternals(amountPaid);
        return sale.pay(amountPaid);
    }
    private void updateExternals(double amountPaid){
        exInSys.updateInventory(sale);
        accSys.logSale(sale);
        register.updateAmountInRegister(amountPaid);
    }
    
}
