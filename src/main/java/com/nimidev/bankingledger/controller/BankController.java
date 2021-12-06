package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.Bank;
import com.nimidev.bankingledger.dto.BankDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.BankManagerService;
import com.nimidev.bankingledger.service.HelperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_BANK;

@RestController
@RequestMapping(value = BASE_API_BANK, produces = HttpConstants.APPLICATION_JSON)
public class BankController {

    BankManagerService bankManagerService;
    private HelperService helperService;

    BankController(BankManagerService bankManagerService, HelperService helperService){
        this.bankManagerService = bankManagerService;
        this.helperService = helperService;
    }

    @PostMapping(path = "/new" ,consumes={"application/json"})
    public ResponseEntity<BankDTO> createBank(@RequestBody BankDTO bankDTO) throws ItemNotFoundException {
        return new ResponseEntity<>(bankManagerService.create(bankDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}" )
    public ResponseEntity<BankDTO> getBankById(@PathVariable String id) throws ItemNotFoundException {
        return new ResponseEntity<>(bankManagerService.get(Long.parseLong(id)),HttpStatus.OK);
    }

//    @DeleteMapping(path = "/delete/{id}")
//    public ResponseEntity<Void> deleteBankById(@PathVariable String id) {
//        return new ResponseEntity<>(bankManagerService.delete(Long.parseLong(id)), HttpStatus.OK);
//    }

}
