package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Transaction;
import com.nimidev.bankingledger.dto.AccountDTO;
import com.nimidev.bankingledger.dto.CurrencyDTO;
import com.nimidev.bankingledger.dto.TransactionDTO;
import com.nimidev.bankingledger.enums.TransactionType;
import com.nimidev.bankingledger.exception.BalanceNotSufficientException;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class TransactionServiceImpl implements TransactionService {

  private HelperService helperService;
  private TransactionRepository transactionRepository;
  private AccountService accountService;

  public TransactionServiceImpl(
          HelperService helperService,
          TransactionRepository transactionRepository,
          AccountService accountService, CurrencyService currencyService) {
    this.helperService = helperService;
    this.transactionRepository = transactionRepository;
    this.accountService = accountService;
  }

  @Override
  public TransactionDTO get(Long id) throws ItemNotFoundException {
    return helperService.map(transactionRepository
        .findById(id)
        .orElseThrow(() -> new ItemNotFoundException("Transaction not found")) , TransactionDTO.class);
  }

  @Override
  public TransactionDTO create(TransactionDTO transactionDTO){
    return helperService.map(transactionRepository.save(helperService.map(transactionDTO , Transaction.class)) , TransactionDTO.class);
  }

  @Override
  public TransactionDTO createTransaction(TransactionDTO transactionDTO) throws BalanceNotSufficientException, ItemNotFoundException {
    AccountDTO accountDTO = accountService.getAccountByAccountNo(transactionDTO.getAccount().getAccountNo());
    if (accountDTO != null) {
      if (transactionDTO.getTrType().equals(TransactionType.CREDIT)) {
        if (accountDTO.getCurrentBalance() < transactionDTO.getTrAmount()) {
          throw new BalanceNotSufficientException(
              "Balance Not sufficient to perform this transaction. Please try again !");
        } else {
          accountDTO.setCurrentBalance(accountDTO.getCurrentBalance() - transactionDTO.getTrAmount());
        }
      } else if (transactionDTO.getTrType().equals(TransactionType.DEBIT)) {
        accountDTO.setCurrentBalance(accountDTO.getCurrentBalance() + transactionDTO.getTrAmount());
      }
      return helperService.map(transactionRepository.save(helperService.map(transactionDTO , Transaction.class)) , TransactionDTO.class);
    } else {
      throw new ItemNotFoundException(
          MessageFormat.format(
              "Account not found for the account no {0} ",
                  transactionDTO.getAccount().getAccountNo()));
    }
  }

  @Override
  public TransactionDTO update(TransactionDTO transactionDTO) {
    return helperService.map(transactionRepository.save(helperService.map(transactionDTO , Transaction.class)) , TransactionDTO.class);
  }

  @Override
  public void delete(Long id) {
    transactionRepository.deleteById(id);
  }
}
