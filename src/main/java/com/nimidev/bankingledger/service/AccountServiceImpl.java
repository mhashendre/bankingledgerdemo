package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.dto.AccountDTO;
import com.nimidev.bankingledger.dto.BankBranchDTO;
import com.nimidev.bankingledger.dto.CurrencyDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.AccountRepository;
import com.nimidev.bankingledger.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class AccountServiceImpl implements AccountService {

  private AccountRepository accountRepository;
  private HelperService helperService;
  private CurrencyService currencyService;
  private BankBranchService bankBranchService;

  AccountServiceImpl(AccountRepository accountRepository, HelperService helperService, CurrencyRepository currencyRepository, CurrencyService currencyService, BankBranchService bankBranchService) {
    this.accountRepository = accountRepository;
    this.helperService = helperService;
    this.currencyService = currencyService;
    this.bankBranchService = bankBranchService;
  }

  @Override
  public AccountDTO get(Long id) throws ItemNotFoundException {
    return helperService.map(accountRepository
        .findById(id)
        .orElseThrow(
            () ->
                new ItemNotFoundException(
                    MessageFormat.format("Account not found for the given id {0} ", id))) , AccountDTO.class);
  }

  @Override
  public AccountDTO create(AccountDTO accountDTO) throws ItemNotFoundException {
    CurrencyDTO currencyDTO = currencyService.getCurrencyByCode(accountDTO.getCurrency().getCurrencyCode());
    accountDTO.setCurrency(currencyDTO);
    BankBranchDTO bankBranchDTO =bankBranchService.getBranchByCode(accountDTO.getBankBranch().getBranchCode());
    accountDTO.setBankBranch(bankBranchDTO);
    return helperService.map(accountRepository.save(helperService.map(accountDTO , Account.class)) , AccountDTO.class);
  }

  @Override
  public AccountDTO update(AccountDTO accountDTO) {
    return helperService.map(accountRepository.save(helperService.map(accountDTO , Account.class)) , AccountDTO.class);
  }

  @Override
  public void delete(Long id) {
    accountRepository.deleteById(id);
  }

  @Override
  public AccountDTO getAccountByAccountNo(String accNo) {
    return helperService.map(accountRepository.findByAccountNo(accNo) , AccountDTO.class);
  }
}
