package se.kth.iv1350.amazingpos.view;


import java.io.IOException;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.ExternalInvetoryInventoryException;
import se.kth.iv1350.amazingpos.model.CurItem;
import se.kth.iv1350.amazingpos.model.InvalidItemIDException;
/**
 * Represents a view that can display information of the sale
 */
public class View {
    private Controller contr;
    /**
     * Creates an instance of the object with a reference to the controller 
     * @param contr uses the reference to control the flow of the sale.
     * @throws IOException
     */
    public View(Controller contr) throws IOException{
        this.contr = contr;
        this.contr.addSaleObserver(new TotalRevenueView());
        this.contr.addSaleObserver(new TotalRevenueFileOutput());
    }
    /**
     * Runs a fake execution of the sale
     */
    public void runFakeExecution(){
        
       for(int j = 0; j < 3; j++){
        contr.startSale();
        System.out.println("----------------- New Sale--------------");
       for(int i = 6; i > 1; i--){
            CurItem scannedItem;
            try {
                scannedItem = contr.scanItem(i, i);
                System.out.println(scannedItem.getItemDesc()+", Pris:"+scannedItem.getItemPrice()+", totala priset:"+scannedItem.getRuningTotal());
            } catch (InvalidItemIDException e) {
                System.out.println(e.getMessage());
            } catch (Exception exc){
                System.out.println(exc.getMessage());
            }
       }
     
       double totalPrice = contr.endSale();
       System.out.println(totalPrice);
       double changeToGive = contr.payment(550);
       System.out.println("Change to give :"+changeToGive);
       System.out.println("----------------- End Of Sale--------------");
       System.out.println("\n");
       
    }
       try {
        System.out.println("Using hardcoded ID to test if exception is thrown ");
        contr.scanItem(3, 7);
        } catch (InvalidItemIDException e) {
            System.out.println(e.getMessage());
        } catch (Exception exc){
            System.out.println(exc);
        }
    }
}
