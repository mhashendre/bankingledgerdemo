package com.zuhlke.salesorderprocessor.exceptions;

import lombok.Getter;

public class MandatoryFieldNotFoundException extends Exception{
    public MandatoryFieldNotFoundException(String message){
        super(message);
    }
}
