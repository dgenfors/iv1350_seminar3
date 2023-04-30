package se.kth.iv1350.amazingpos.view;

import java.util.Random;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.model.CurItem;

public class View {
    private Controller contr;
    private Random rndm;
    public View(Controller contr){
        this.contr = contr;
        this.rndm = new Random();
    }

    public void runFakeExecution(){
        contr.startSale();
       
       for(int i = 1; i < 4; i++){
        CurItem scannedItem = contr.scanItem(i, i);
        System.out.println(scannedItem.getItemDesc()+" "+scannedItem.getRuningTotal());
       }
       double totalPrice = contr.endSale();
       System.out.println(totalPrice);
       double changeToGive = contr.payment(440);
       System.out.println(changeToGive);

    }
}
