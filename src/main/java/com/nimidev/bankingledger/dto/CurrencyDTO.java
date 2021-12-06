package com.nimidev.bankingledger.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.domain.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class CurrencyDTO extends Audit {

    private Long id;
    private String currencyCode;
    private String currency;
    private List<AccountDTO> accounts;
}
