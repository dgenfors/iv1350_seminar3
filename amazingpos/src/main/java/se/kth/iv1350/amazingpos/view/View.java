package se.kth.iv1350.amazingpos.view;


import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.model.CurItem;
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
       
       for(int i = 1; i < 4; i++){
        CurItem scannedItem = contr.scanItem(i, i);
        System.out.println(scannedItem.getItemDesc()+", Pris:"+scannedItem.getItemPrice()+", totala priest:"+scannedItem.getRuningTotal());
       }
       double totalPrice = contr.endSale();
       System.out.println(totalPrice);
       double changeToGive = contr.payment(550);
       System.out.println("Change to give :"+changeToGive);

    }
}
