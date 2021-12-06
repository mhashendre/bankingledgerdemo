package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.BankBranch;
import com.nimidev.bankingledger.dto.BankBranchDTO;
import com.nimidev.bankingledger.exception.BalanceNotSufficientException;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.BankBranchService;
import com.nimidev.bankingledger.service.HelperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_BANK_BRANCH;

@RestController
@RequestMapping(value = BASE_API_BANK_BRANCH, produces = HttpConstants.APPLICATION_JSON)
public class BankBranchController {

    private BankBranchService bankBranchService;
    private HelperService helperService;

    BankBranchController(BankBranchService bankBranchService, HelperService helperService){
        this.bankBranchService = bankBranchService;
        this.helperService = helperService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<BankBranchDTO> createBankBranch(@RequestBody BankBranchDTO bankBranchDTO ) throws ItemNotFoundException {
        return new ResponseEntity<>(bankBranchService.create(bankBranchDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BankBranchDTO> getBankById(@PathVariable String id) throws ItemNotFoundException {
        return new ResponseEntity<>(bankBranchService.get(Long.parseLong(id)),HttpStatus.OK);
    }

//    @DeleteMapping(path = "/delete/{id}")
//    public ResponseEntity<Void> deleteBankBranchById(@PathVariable String id) {
//        return new ResponseEntity<>(bankBranchService.delete(Long.parseLong(id)), HttpStatus.OK);
//    }
}
