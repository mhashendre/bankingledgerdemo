package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimidev.bankingledger.domain.Audit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankDTO extends Audit {
    private Long id;
    private String bankCode;
    private String bankName;
    private List<BankBranchDTO> bankBranches;
    private List<AccountDTO> accountList;
}
