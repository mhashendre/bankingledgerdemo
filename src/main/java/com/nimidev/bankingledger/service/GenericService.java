package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.exception.BalanceNotSufficientException;
import com.nimidev.bankingledger.exception.ItemNotFoundException;

import java.util.Optional;

public interface GenericService<T> {
    T get(Long id) throws ItemNotFoundException;
    T create(T t) throws ItemNotFoundException;
    T update(T t);
    void delete(Long id);
}
