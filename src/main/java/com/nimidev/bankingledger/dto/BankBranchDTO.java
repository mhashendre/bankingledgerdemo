package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.domain.Audit;
import com.nimidev.bankingledger.domain.Bank;
import com.nimidev.bankingledger.domain.BankBranch;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class BankBranchDTO extends Audit {

    private Long id;
    private String branchCode;
    private String branchName;
    private String branchAddress;
    private BankDTO bank;
}
