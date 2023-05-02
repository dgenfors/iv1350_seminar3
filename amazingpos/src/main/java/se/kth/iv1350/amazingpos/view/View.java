package se.kth.iv1350.amazingpos.view;


import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.model.CurItem;

public class View {
    private Controller contr;
    public View(Controller contr){
        this.contr = contr;
    }

    public void runFakeExecution(){
        contr.startSale();
       
       for(int i = 1; i < 4; i++){
        CurItem scannedItem = contr.scanItem(5-i, 5-i);
        System.out.println(scannedItem.getItemDesc()+", "+scannedItem.getItemPrice()+", "+scannedItem.getRuningTotal());
       }
       double totalPrice = contr.endSale();
       System.out.println(totalPrice);
       double changeToGive = contr.payment(550);
       System.out.println("Change to give :"+changeToGive);

    }
}
