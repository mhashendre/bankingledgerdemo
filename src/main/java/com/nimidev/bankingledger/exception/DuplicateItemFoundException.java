package com.nimidev.bankingledger.exception;

public class DuplicateItemFoundException extends Exception{
    public DuplicateItemFoundException(String message){
        super(message);
    }
}
