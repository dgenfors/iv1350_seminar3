package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.view.View;

public class Main {
    public static void main(String args[]){
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }
}
