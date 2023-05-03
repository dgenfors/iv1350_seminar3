/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.amazingpos.integration.ItemDTO;

/**
 *
 * @author davve
 */
public class SaleTest {
    private Sale sale;
    private ItemDTO item;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item = new ItemDTO(50, 0.25, "lätt mjölk", 1);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
    }

    @Test
    public void testAdditem() {
        System.out.println("additem");
        int quantity = 1;
        CurItem expResult = new CurItem(item, 62.5);
        CurItem result = sale.additem(item, quantity);
        assertEquals(expResult.getRuningTotal(), result.getRuningTotal());
    }

    @Test
    public void testGetPriceWithVat() {
        System.out.println("getPriceWithVat");
        sale.additem(item, 4);
        double expResult = 250;
        double result = sale.getPriceWithVat();
        assertEquals(expResult, result);
 
    }

    @Test
    public void testGetSoldItems() {
        System.out.println("getSoldItems");
        Sale instance = new Sale();
        List<SoldItem> expResult = null;
        List<SoldItem> result = instance.getSoldItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPriceWithoutVat() {
        System.out.println("getPriceWithoutVat");
        Sale instance = new Sale();
        double expResult = 0.0;
        double result = instance.getPriceWithoutVat();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPay() {
        System.out.println("pay");
        double amountPaid = 0.0;
        Sale instance = new Sale();
        double expResult = 0.0;
        double result = instance.pay(amountPaid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
