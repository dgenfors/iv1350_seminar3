
package se.kth.iv1350.amazingpos.integration;

/**
 *  Thrown when a error occurs in the <code>ExternalInvetorySystem</code>
 */
public class ExternalInvetoryInventoryException extends RuntimeException {
    /**
     * Creates a instance of the exception, 
     * with a msg to explain what went wrong
     * @param msg The message that describes the cause
     */
    public ExternalInvetoryInventoryException(String msg){
        super(msg);
    }
}
