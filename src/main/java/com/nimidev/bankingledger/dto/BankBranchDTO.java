package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "bankBranchId")
public class BankBranchDTO extends Audit {

    private Long bankBranchId;
    private String branchCode;
    private String branchName;
    private String branchAddress;
//    @JsonBackReference
    private BankDTO bank;
//    @JsonManagedReference
    private List<AccountDTO> accounts;
}
