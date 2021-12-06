package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.Transaction;
import com.nimidev.bankingledger.dto.TransactionDTO;
import com.nimidev.bankingledger.exception.BalanceNotSufficientException;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_TRANSACTION;

@RestController
@RequestMapping(value = BASE_API_TRANSACTION, produces = HttpConstants.APPLICATION_JSON)
public class TransactionController {

    private TransactionService transactionService;

    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<TransactionDTO> createNewTransaction(@RequestBody TransactionDTO transactionDTO) throws ItemNotFoundException, BalanceNotSufficientException {
        return new ResponseEntity<>(transactionService.createTransaction(transactionDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/gettrbyid/{id}")
    public ResponseEntity<TransactionDTO> getTranactionByid(@PathVariable String id) throws ItemNotFoundException {
        return new ResponseEntity<>(transactionService.get(Long.parseLong(id)) , HttpStatus.OK);
    }
}
