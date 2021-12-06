package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Bank;
import com.nimidev.bankingledger.domain.BankBranch;
import com.nimidev.bankingledger.dto.BankDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class BankManagerServiceImpl implements BankManagerService {

  private BankRepository bankRepository;
  private HelperService helperService;

  BankManagerServiceImpl(BankRepository bankRepository, HelperService helperService) {
    this.bankRepository = bankRepository;
    this.helperService = helperService;
  }

  @Override
  public BankDTO get(Long id) throws ItemNotFoundException {
    return helperService.map(bankRepository
        .findById(id)
        .orElseThrow(
            () ->
                new ItemNotFoundException(
                    MessageFormat.format("No Bank found for the given id {0}", id))),BankDTO.class);
  }

    @Override
  public BankDTO create(BankDTO bank) {
    return helperService.map(bankRepository.save(helperService.map(bank , Bank.class)),BankDTO.class);
  }

  @Override
  public BankDTO update(BankDTO bank) {
    return helperService.map(bankRepository.save(helperService.map(bank , Bank.class)),BankDTO.class);
  }

  @Override
  public void delete(Long id) {
    bankRepository.deleteById(id);
  }
}
