package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.dto.AccountDTO;


public interface AccountService extends GenericService<AccountDTO>{

    AccountDTO getAccountByAccountNo(String accNo);
}
