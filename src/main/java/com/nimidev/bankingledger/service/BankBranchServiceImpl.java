package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.BankBranch;
import com.nimidev.bankingledger.dto.BankBranchDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.BankBranchRepository;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class BankBranchServiceImpl implements BankBranchService {

  private BankBranchRepository bankBranchRepository;
  private HelperService helperService;

  public BankBranchServiceImpl(
      BankBranchRepository bankBranchRepository, HelperService helperService) {
    this.bankBranchRepository = bankBranchRepository;
    this.helperService = helperService;
  }

  @Override
  public BankBranchDTO get(Long id) throws ItemNotFoundException {
    return helperService.map(
        bankBranchRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ItemNotFoundException(
                        MessageFormat.format("Branch not found for id {0}", id))),
        BankBranchDTO.class);
  }

  @Override
  public BankBranchDTO create(BankBranchDTO bankBranchDTO) {
    return helperService.map(
        bankBranchRepository.save(helperService.map(bankBranchDTO, BankBranch.class)),
        BankBranchDTO.class);
  }

  @Override
  public BankBranchDTO update(BankBranchDTO bankBranchDTO) {
    return helperService.map(
        bankBranchRepository.save(helperService.map(bankBranchDTO, BankBranch.class)),
        BankBranchDTO.class);
  }

  @Override
  public void delete(Long id) {
    bankBranchRepository.deleteById(id);
  }

  @Override
  public BankBranchDTO getBranchByCode(String branchCode) throws ItemNotFoundException {
    return helperService.map(
        bankBranchRepository
            .findBankBranchByBranchCode(branchCode)
            .orElseThrow(
                () ->
                    new ItemNotFoundException(
                        MessageFormat.format("Branch Not found by this code {0}", branchCode))),
        BankBranchDTO.class);
  }
}
