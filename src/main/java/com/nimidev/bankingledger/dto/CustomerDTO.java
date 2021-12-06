package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimidev.bankingledger.domain.Audit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO extends Audit {

    private Long id;
    private String fistName;
    private String lastName;
    private String nic;
    private String mobileNo;
    private String address;
    private List<AccountDTO> accounts;
    private String dob;
}
