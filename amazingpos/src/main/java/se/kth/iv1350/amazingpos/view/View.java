package se.kth.iv1350.amazingpos.view;


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
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Runs a fake execution of the sale
     */
    public void runFakeExecution(){
        contr.startSale();
       
       for(int i = 6; i > 1; i--){
            CurItem scannedItem;
            try {
                scannedItem = contr.scanItem(i, i);
                System.out.println(scannedItem.getItemDesc()+", Pris:"+scannedItem.getItemPrice()+", totala priset:"+scannedItem.getRuningTotal());
            } catch (InvalidItemIDException e) {
                System.out.println(e.getMessage());
            } catch (Exception exc){
            
            }
       }
     
       double totalPrice = contr.endSale();
       System.out.println(totalPrice);
       double changeToGive = contr.payment(550);
       System.out.println("Change to give :"+changeToGive);

       try {
        contr.scanItem(3, 7);
        } catch (InvalidItemIDException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }

    private void writeToLogAndUI(String uiMsg, Exception exc) {
    }
}
