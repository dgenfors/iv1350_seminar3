package se.kth.iv1350.amazingpos.model;

public class InvalidItemIDException extends Exception {
    public InvalidItemIDException(){
        super("Specified ItemID could not be found in inventory, try scan again");
    }
}
