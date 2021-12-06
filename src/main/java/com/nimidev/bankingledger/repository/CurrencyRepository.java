package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency , Long> {

    Optional<Currency> getCurrencyByCurrencyCode(String code);
}
