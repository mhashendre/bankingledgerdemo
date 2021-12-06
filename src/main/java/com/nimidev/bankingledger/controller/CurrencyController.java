package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.Currency;
import com.nimidev.bankingledger.dto.CurrencyDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.CurrencyService;
import com.nimidev.bankingledger.service.HelperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_CURRENCY;

@RestController
@RequestMapping(value = BASE_API_CURRENCY, produces = HttpConstants.APPLICATION_JSON)
public class CurrencyController {

    private CurrencyService currencyService;
    private HelperService helperService;

    CurrencyController(CurrencyService currencyService, HelperService helperService){
        this.currencyService = currencyService;
        this.helperService = helperService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<CurrencyDTO> createCurrency(@RequestBody CurrencyDTO currencyDTO) throws ItemNotFoundException {
        return new ResponseEntity<>(currencyService.create(currencyDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<CurrencyDTO> getCurrencyByCode(@PathVariable String code) throws ItemNotFoundException {
        return new ResponseEntity<>(currencyService.getCurrencyByCode(code),HttpStatus.OK);
    }
}
