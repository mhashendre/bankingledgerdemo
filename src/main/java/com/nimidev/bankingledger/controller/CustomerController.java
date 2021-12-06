package com.nimidev.bankingledger.controller;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.domain.Customer;
import com.nimidev.bankingledger.dto.CustomerDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nimidev.bankingledger.constants.UtilConstants.BASE_API_CUSTOMER;

@RestController
@RequestMapping(value = BASE_API_CUSTOMER, produces = HttpConstants.APPLICATION_JSON)
public class CustomerController {

    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(path = "new")
    public ResponseEntity<CustomerDTO> createCustomer (@RequestBody CustomerDTO customerDTO) throws ItemNotFoundException {
        return new ResponseEntity<>(customerService.create(customerDTO) , HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) throws ItemNotFoundException {
        return new ResponseEntity<>(customerService.get(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping(path = "/accounts/{nic}")
    public ResponseEntity<CustomerDTO> getAllAccountDetailsByNic(@PathVariable String nic){
        return new ResponseEntity<>(customerService.getAllAccountDetailsByNic(nic) , HttpStatus.OK);
    }

}
