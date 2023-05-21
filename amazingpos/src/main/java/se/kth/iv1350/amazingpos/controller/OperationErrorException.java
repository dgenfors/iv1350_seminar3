package se.kth.iv1350.amazingpos.controller;
/**
 * Thrown when a undeyling operation has failed.
 */
public class OperationErrorException extends Exception{
    /**
     * Creates a new instance with the exception message and cause
     * @param msg The exception message
     * @param cause The exception cause
     */
    public OperationErrorException(String msg, Exception cause){
        super(msg, cause);
    }
}
