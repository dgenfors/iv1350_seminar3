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
       CurItem scannedItem = contr.scanItem(0, 0);
       System.out.println(scannedItem.getRuningTotal());

    }
}
