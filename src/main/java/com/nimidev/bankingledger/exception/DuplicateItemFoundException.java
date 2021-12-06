package com.zuhlke.salesorderprocessor.exceptions;

public class DuplicateItemFoundException extends Exception{
    public DuplicateItemFoundException(String message){
        super(message);
    }
}
