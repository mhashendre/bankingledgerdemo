package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.Bank;
import com.nimidev.bankingledger.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
}
