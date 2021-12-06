package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.BankBranch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankBranchRepository extends CrudRepository<BankBranch , Long> {

    Optional<BankBranch> findBankBranchByBranchCode(String code);
}
