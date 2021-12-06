package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.domain.Audit;
import com.nimidev.bankingledger.enums.TransactionMethod;
import com.nimidev.bankingledger.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO extends Audit {

    private Long id;
    private AccountDTO account;
    private TransactionType trType;
    private double trAmount;
    private LocalDateTime trDateTime;
    private TransactionMethod transactionMethod;

}


