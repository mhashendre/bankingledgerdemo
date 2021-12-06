package com.nimidev.bankingledger.repository;

import com.nimidev.bankingledger.domain.Customer;
import com.nimidev.bankingledger.dto.CustomerDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , Long> {

    Customer findByNic(String nic);
}
