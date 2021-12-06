package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.dto.AccountDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_ACCOUNT;

@RestController
@RequestMapping(value = BASE_API_ACCOUNT, produces = HttpConstants.APPLICATION_JSON)
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) throws ItemNotFoundException {
        return  new ResponseEntity<>(accountService.create(accountDTO) , HttpStatus.OK);
    }

    @GetMapping(path = "/{accNo}")
    public ResponseEntity<AccountDTO> getAccountByAccNo(@PathVariable String accNo) {
        return new ResponseEntity<>(accountService.getAccountByAccountNo(accNo) , HttpStatus.OK);
    }
}
