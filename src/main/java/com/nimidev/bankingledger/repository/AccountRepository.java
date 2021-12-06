package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    Account findByAccountNo(String accNo);
}
