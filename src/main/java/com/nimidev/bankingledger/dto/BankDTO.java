package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nimidev.bankingledger.domain.Audit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "bankId")
public class BankDTO extends AuditDTO {
    private Long bankId;
    private String bankCode;
    private String bankName;
//    @JsonManagedReference
    private List<BankBranchDTO> bankBranches;
}
