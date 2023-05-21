package se.kth.iv1350.amazingpos.model;
/**
 * Thrown when a itemID can not be found in the externalInventorySystem
 */
public class InvalidItemIDException extends Exception {
    /**
     * Creates a instance of the exception to be thrown
     * which explains the specific reason of why it was thrown.
     */
    public InvalidItemIDException(){
        super("Specified ItemID could not be found in inventory, try scan again");
    }
}
