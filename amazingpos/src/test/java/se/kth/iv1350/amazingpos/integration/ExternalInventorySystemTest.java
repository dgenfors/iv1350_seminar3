/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.model.Sale;

/**
 *
 * @author davve
 */
public class ExternalInventorySystemTest {
    ExternalInventorySystem exInSys;
    
    @BeforeEach
    public void setUp() {
        exInSys = new ExternalInventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        exInSys = null;
    }

    @Test
    public void testGetItemDescription() {
        int itemID = 4;
        double price = 30;
        double vatRate = 0.06;
        String itemDesc = "kyckling";
        ItemDTO expResult = new ItemDTO(price, vatRate, itemDesc,itemID);
        ItemDTO result = exInSys.getItemDescription(itemID);
        assertEquals(expResult.getPrice(), result.getPrice());
        assertEquals(expResult.getVatRate(), result.getVatRate());
        assertEquals(expResult.getItemDesc(), result.getItemDesc());
         
        
    }
    
}
