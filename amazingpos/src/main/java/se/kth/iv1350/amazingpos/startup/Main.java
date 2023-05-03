package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.view.View;
/**
 * Represents the Main class of the System
 */
public class Main {
    /**
     * Starts up the program and creates the needed references for
     * later user.
     * @param args never used
     */
    public static void main(String args[]){
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }
}
