/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

import java.util.ArrayList;
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
    private ItemDTO item2;
    private SoldItem soldItem;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item = new ItemDTO(50, 0.25, "lätt mjölk", 1);
        item2 = new ItemDTO(30, 0.12, "chips", 2);
        soldItem = new SoldItem(item, 3);
    }
    
    @AfterEach
    public void tearDown() {
        sale = null;
    }

    @Test
    public void testPriceAfterAddingOneItem() {
        
        int quantity = 1;
        double expResult = 62.5;
        sale.additem(item, quantity);
        double result = sale.getPriceWithVat();
        assertEquals(expResult, result,"RuningTotal was not equal");
    }
    @Test
    public void testPriceAfterAddingMutipleItem() {
        
        int quantity = 2;
        double expResult = 192.2;
        sale.additem(item, quantity);
        sale.additem(item2, quantity);
        double result = sale.getPriceWithVat();
        assertEquals(expResult, result,"RuningTotal was not equal");
    }

    @Test
    public void testGetPriceWithVat() {
        sale.additem(item, 4);
        double expResult = 250;
        double result = sale.getPriceWithVat();
        assertEquals(expResult, result,"Vat calculation did not equal");
 
    }

    @Test
    public void testGetSoldItemsEmptyList() {
        List<SoldItem> expResult = new ArrayList<>();
        List<SoldItem> result = sale.getSoldItems();
        assertEquals(expResult, result,"Same instance did not equal");
    }
    @Test
    public void testGetSoldItemsFilledList() {
        List<SoldItem> list = new ArrayList<>();
        list.add(soldItem);
        sale.additem(item, 3);
        List<SoldItem> classList = sale.getSoldItems();
        ItemDTO result =classList.get(0).getItem();
        ItemDTO expResult = list.get(0).getItem();
        assertEquals(expResult, result,"Same instance did not equal");
    }

    @Test
    public void testGetPriceWithoutVat() {
        sale.additem(item, 4);
        double expResult = 200;
        double result = sale.getPriceWithoutVat();
        assertEquals(expResult, result,"Price calculation failed");
    }

    @Test
    public void testPay() {
        double amountPaid = 150;
        double expResult = 25;
        sale.additem(item, 2);
        double result = sale.pay(amountPaid);
        assertEquals(expResult, result, "Faulty calculation for the change");
        
    }
    @Test
    public void testAddSameItem() {
        sale.additem(item, 2);
        sale.additem(item, 3);
        int expResult = 5;
        List<SoldItem>soldItems= sale.getSoldItems();
        int result = soldItems.get(0).getQuantity();
        assertEquals(expResult, result, "Wrong quantity added for the same item");
        
    }
    
}
