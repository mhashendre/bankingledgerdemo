package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.*;
import com.nimidev.bankingledger.domain.*;
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
        property = "accountId")
public class AccountDTO extends Audit {

    private Long accountId;
    private String accountNo;
    private double currentBalance;
    private CustomerDTO customer;
    private BankBranchDTO bankBranch;
    private List<TransactionDTO> transactions;
    private CurrencyDTO currency;
}
