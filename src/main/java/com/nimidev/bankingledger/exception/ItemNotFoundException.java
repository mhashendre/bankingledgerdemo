package com.zuhlke.salesorderprocessor.exceptions;

import lombok.Getter;

@Getter
public class ItemNotFoundException  extends Exception{
    public ItemNotFoundException(String message){
        super(message);
    }
}
