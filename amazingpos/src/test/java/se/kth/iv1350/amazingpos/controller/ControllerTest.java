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
    public void testHardCodedItemIDScanItem() throws InvalidItemIDException{
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
     @Test
    public void testScanInvalidItemID() throws OperationErrorException{
        int quantity = 1;
        Integer itemID = 100;
        CurItem expResult = null;
        try{
             CurItem result = cntr.scanItem(quantity, itemID);
             fail("Could scan a invalid ItemID");
        }catch (OperationErrorException exc){
           fail("wrong exception was thrown"+exc);
        }catch (InvalidItemIDException exc){
            assertTrue(exc.getMessage().contains("Specified ItemID could not be found"),"Wrong exception message did not contain" +exc.getMessage());
        } 
    }
    
      @Test
    public void testScanValidtemID() throws OperationErrorException{
        int quantity = 1;
        int itemID = 1;
        double expResultPrice = 50;
        String expResultDesc = "lätt mjölk";
        try{
             CurItem result = cntr.scanItem(quantity, itemID);
            assertEquals(result.getItemPrice(),expResultPrice, "Faulty item Price");
            assertEquals(result.getItemDesc(),expResultDesc, "Faulty item Description");
        }catch (OperationErrorException exc){
           fail("Exception was thrown on valid ItemID "+exc);
        }catch (InvalidItemIDException exc){
            fail("Exception was thrown on valid ItemID "+exc);
        } 
    }

    
}
