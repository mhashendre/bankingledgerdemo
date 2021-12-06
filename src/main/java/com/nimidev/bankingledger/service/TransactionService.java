package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Transaction;
import com.nimidev.bankingledger.dto.TransactionDTO;
import com.nimidev.bankingledger.exception.BalanceNotSufficientException;
import com.nimidev.bankingledger.exception.ItemNotFoundException;

public interface TransactionService extends GenericService<TransactionDTO> {

    TransactionDTO createTransaction(TransactionDTO transactionDTO) throws BalanceNotSufficientException, ItemNotFoundException;

}
