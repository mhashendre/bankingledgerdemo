package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction , Long> {
}
