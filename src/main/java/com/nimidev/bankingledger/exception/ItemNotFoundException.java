package com.nimidev.bankingledger.exception;

import lombok.Getter;

@Getter
public class ItemNotFoundException  extends Exception{
    public ItemNotFoundException(String message){
        super(message);
    }
}
