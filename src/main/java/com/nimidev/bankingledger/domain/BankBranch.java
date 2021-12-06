package com.nimidev.bankingledger.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BankBranch extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankBranchId;

    @Column(nullable = false,unique = true)
    private String branchCode;

    @Column(nullable = false,unique = true)
    private String branchName;

    private String branchAddress;

    @OneToMany(mappedBy = "bankBranch")
    private List<Account> accounts;

    @ManyToOne
    @JoinColumn(name = "bankId")
    private Bank bank;

}
