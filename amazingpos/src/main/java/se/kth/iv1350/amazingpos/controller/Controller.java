package se.kth.iv1350.amazingpos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.amazingpos.integration.AccountingSystem;
import se.kth.iv1350.amazingpos.integration.DiscountRegister;
import se.kth.iv1350.amazingpos.integration.ExternalInventorySystem;
import se.kth.iv1350.amazingpos.integration.ExternalInvetoryInventoryException;
import se.kth.iv1350.amazingpos.integration.Register;
import se.kth.iv1350.amazingpos.model.CurItem;
import se.kth.iv1350.amazingpos.model.InvalidItemIDException;
import se.kth.iv1350.amazingpos.model.ItemManager;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleObserver;
import se.kth.iv1350.amazingpos.util.LogHandler;
/**
 * Represents a controller to be used in a sale
 */
public class Controller {
    private ExternalInventorySystem exInSys;
    private DiscountRegister disReg;
    private AccountingSystem accSys;
    private Register register;
    private ItemManager itmMnger;
    private Sale sale;
    private LogHandler loghandler;
    private List<SaleObserver> saleObserver = new ArrayList<>();
    /**
     * Creates an instance of the object and its needed references.
     * @throws IOException
     */
    public Controller() throws IOException{
        this.exInSys = new ExternalInventorySystem();
        this.disReg = new DiscountRegister();
        this.accSys = new AccountingSystem();
        this.register = new Register();
        this.loghandler = new LogHandler("amazingpos-errorLog.txt");
    }

    /**
     * Starts a new sale, this method must be called before doing anything else in a sale 
     * */
    public void startSale(){
        this.sale = new Sale();
        this.itmMnger = new ItemManager(this.exInSys, this.sale);
        sale.addObserver(saleObserver);
        
    }
    /**
     * Uses the parameters to add locate the specified item and 
     * send the information to sale to be used there.
     * @param quantity amount of items
     * @param itemID   the unique identifier of the item 
     * used to get the matching item
     * @return the item mathcing the ItemId and the runingTotal of the sale after returning the item
     * @throws se.kth.iv1350.amazingpos.controller.OperationErrorException
     * @throws InvalidItemIDException
     */
    public CurItem scanItem(int quantity, int itemID) throws OperationErrorException, InvalidItemIDException{
        try{
            return itmMnger.geItem(quantity, itemID);
        }catch(ExternalInvetoryInventoryException exInvExc){
            loghandler.logException(exInvExc);
            throw new OperationErrorException(exInvExc.getMessage(), exInvExc);
        }
        
    }
    /**
     * End the sale, this method must be called before handling payment
     * @return the totalPrice of the Sale
     */
    public double endSale(){
        return sale.getPriceWithVat();
    }
    /**
     * Updates all the external systems with the information of the ended sale
     * and gets the needed information from sale.
     * @param amountPaid used to update the register
     * @return the change to be given.
     */
    public double payment(double amountPaid){
        updateExternals(amountPaid);
        return sale.pay(amountPaid);
    }

    public void addSaleObserver(SaleObserver obs){
        saleObserver.add(obs);
    }
    private void updateExternals(double amountPaid){
        exInSys.updateInventory(sale);
        accSys.logSale(sale);
        register.updateAmountInRegister(amountPaid);
    }
    
}
