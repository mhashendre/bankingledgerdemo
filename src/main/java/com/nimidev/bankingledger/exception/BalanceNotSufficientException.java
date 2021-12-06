package com.nimidev.bankingledger.exception;

public class BalanceNotSufficientException  extends  Exception{
    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
