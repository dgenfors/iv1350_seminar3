/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.controller;

import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.integration.ExternalInvetoryInventoryException;
import se.kth.iv1350.amazingpos.model.CurItem;
import se.kth.iv1350.amazingpos.model.InvalidItemIDException;
import se.kth.iv1350.amazingpos.model.SaleObserver;

/**
 *
 * @author davve
 */
public class ControllerTest {
    private Controller cntr;
    
    
    @BeforeEach
    public void setUp() throws IOException {
        cntr = new Controller();
        cntr.startSale();
    }
    
    @AfterEach
    public void tearDown() {
    }

   
    @Test
    public void testScanItem() throws InvalidItemIDException{
        int quantity = 1;
        int itemID = 7;
        CurItem expResult = null;
        try{
             CurItem result = cntr.scanItem(quantity, itemID);
             fail("Could scan hardcoded ItemID");
        }catch (OperationErrorException exInvExc){
            assertEquals(exInvExc.getMessage(),"Database could not be called", "Faulty Exception was thrown");
        }
        
    }

   
    /*@Test
    public void testEndSale() {
        double expResult = 0.0;
        double result = cntr.endSale();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testPayment() {
        double amountPaid = 0.0;
        double expResult = 0.0;
        double result = cntr.payment(amountPaid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testAddSaleObserver() {
        SaleObserver obs = null;
        cntr.addSaleObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
