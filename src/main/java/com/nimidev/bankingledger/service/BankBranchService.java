package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.BankBranch;
import com.nimidev.bankingledger.dto.BankBranchDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;


public interface BankBranchService extends GenericService<BankBranchDTO> {

    BankBranchDTO getBranchByCode(String branchCode) throws ItemNotFoundException;
}
