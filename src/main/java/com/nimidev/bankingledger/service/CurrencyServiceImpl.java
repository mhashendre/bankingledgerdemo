package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Currency;
import com.nimidev.bankingledger.dto.CurrencyDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class CurrencyServiceImpl implements CurrencyService {

  private CurrencyRepository currencyRepository;
  private HelperService helperService;

  CurrencyServiceImpl(CurrencyRepository currencyRepository, HelperService helperService) {
    this.currencyRepository = currencyRepository;
    this.helperService = helperService;
  }

  @Override
  public CurrencyDTO get(Long id) throws ItemNotFoundException {
    return helperService.map(currencyRepository
        .findById(id)
        .orElseThrow(
            () -> new ItemNotFoundException(MessageFormat.format("Currency not foung {0}", id))) , CurrencyDTO.class);
  }

  @Override
  public CurrencyDTO create(CurrencyDTO currencyDTO) {
    return helperService.map(currencyRepository.save(helperService.map(currencyDTO , Currency.class)) , CurrencyDTO.class);
  }

  @Override
  public CurrencyDTO update(CurrencyDTO currencyDTO) {
    return helperService.map(currencyRepository.save(helperService.map(currencyDTO , Currency.class)) , CurrencyDTO.class);
  }

  @Override
  public void delete(Long id) {
    currencyRepository.deleteById(id);
  }

  @Override
  public CurrencyDTO getCurrencyByCode(String code) throws ItemNotFoundException {
    return helperService.map(currencyRepository
        .getCurrencyByCurrencyCode(code)
        .orElseThrow(() -> new ItemNotFoundException("Currency not found for code {0}")) , CurrencyDTO.class);
  }
}
