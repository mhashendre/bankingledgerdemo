package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class AccountDTO extends Audit {

    private Long id;

    private String accountNo;
    private double currentBalance;
    private CustomerDTO customer;
    private BankDTO bank;
    private List<TransactionDTO> transactions;
    private CurrencyDTO currency;
}
