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
        property = "customerId")
public class CustomerDTO extends Audit {

    private Long customerId;
    private String fistName;
    private String lastName;
    private String nic;
    private String mobileNo;
    private String address;
//    @JsonManagedReference
    private List<AccountDTO> accounts;
    private String dob;
}
