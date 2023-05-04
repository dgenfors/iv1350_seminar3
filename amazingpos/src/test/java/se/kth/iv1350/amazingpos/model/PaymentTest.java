/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.amazingpos.model;

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
public class PaymentTest {
    private ItemDTO item;
    private Payment payment;
    
    @BeforeEach
    public void setUp() {
        item = new ItemDTO(100, 0.12, "lätt mjölk", 1);
        payment = new Payment();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddVatRate() {
        double expResult = 112;
        double result = payment.addVatRate(item);
        assertEquals(expResult, result, "calculation gave a faulty value");
        
    }

    @Test
    public void testCalcChange() {
        double amountPaid = 120;
        double runingTotal = 100;
       
        double expResult = amountPaid-runingTotal;
        double result = payment.calcChange(amountPaid, runingTotal);
        assertEquals(expResult, result, "Subraction gave a faulty value");
    }
    
}
