package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Currency;
import com.nimidev.bankingledger.dto.CurrencyDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;

public interface CurrencyService extends GenericService<CurrencyDTO> {

    CurrencyDTO getCurrencyByCode(String code) throws ItemNotFoundException;
}
