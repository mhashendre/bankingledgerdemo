package com.nimidev.bankingledger.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nimidev.bankingledger.enums.TransactionMethod;
import com.nimidev.bankingledger.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionid;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @Column(nullable = false)
    private TransactionType trType;

    @Column(nullable = false)
    private double trAmount;

    private LocalDateTime trDateTime;

    @Column(nullable = false)
    private TransactionMethod transactionMethod;
}
