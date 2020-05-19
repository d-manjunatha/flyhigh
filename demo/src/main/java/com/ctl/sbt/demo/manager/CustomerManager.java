package com.ctl.sbt.demo.manager;

import com.ctl.sbt.demo.model.Customer;
import com.ctl.sbt.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> fetchCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}
