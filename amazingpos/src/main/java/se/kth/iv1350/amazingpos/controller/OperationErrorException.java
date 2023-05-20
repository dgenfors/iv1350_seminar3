package se.kth.iv1350.amazingpos.controller;

public class OperationErrorException extends Exception{
    public OperationErrorException(String msg, Exception cause){
        super(msg, cause);
    }
}
