package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.domain.Customer;
import com.nimidev.bankingledger.dto.CustomerDTO;

import java.util.List;

public interface CustomerService extends GenericService<CustomerDTO> {

    CustomerDTO getAllAccountDetailsByNic(String nic);
}
