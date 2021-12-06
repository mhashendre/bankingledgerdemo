package com.nimidev.bankingledger.exception;

public class MandatoryFieldNotFoundException extends Exception{
    public MandatoryFieldNotFoundException(String message){
        super(message);
    }
}
