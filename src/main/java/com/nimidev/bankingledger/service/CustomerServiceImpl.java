package com.nimidev.bankingledger.service;

import com.nimidev.bankingledger.domain.Account;
import com.nimidev.bankingledger.domain.Customer;
import com.nimidev.bankingledger.dto.CustomerDTO;
import com.nimidev.bankingledger.exception.ItemNotFoundException;
import com.nimidev.bankingledger.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private HelperService helperService;

    public CustomerServiceImpl(CustomerRepository customerRepository, HelperService helperService) {
        this.customerRepository = customerRepository;
        this.helperService = helperService;
    }

    @Override
    public CustomerDTO get(Long id) throws ItemNotFoundException {
        return helperService.map(customerRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("CUstomer not found ")) , CustomerDTO.class);
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return helperService.map(customerRepository.save(helperService.map(customerDTO , Customer.class)) , CustomerDTO.class);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return helperService.map(customerRepository.save(helperService.map(customerDTO , Customer.class)) , CustomerDTO.class);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO getAllAccountDetailsByNic(String nic) {
        return helperService.map(customerRepository.findByNic(nic) , CustomerDTO.class);
    }
}
