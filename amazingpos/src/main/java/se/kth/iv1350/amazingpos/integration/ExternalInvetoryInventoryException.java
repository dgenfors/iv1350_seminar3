/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.amazingpos.integration;

/**
 *  Om man kan recover från error--> checked else unchcked
 * @author davve
 */
public class ExternalInvetoryInventoryException extends RuntimeException {
    
    public ExternalInvetoryInventoryException(String msg){
        super(msg);
    }
}
