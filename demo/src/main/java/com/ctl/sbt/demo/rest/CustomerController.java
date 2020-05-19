package com.ctl.sbt.demo.rest;

import com.ctl.sbt.demo.manager.CustomerManager;
import com.ctl.sbt.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerManager customerManager;

    /**
     * This method takes @link Customer and creates in DB
     * @param customer
     * @return the created customer with Id
     */
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Customer createCust(@RequestBody Customer customer){
        return customerManager.createCustomer(customer);
    }

    @GetMapping(path = "/customers")
    public List<Customer> fetchAllCustomers(){
        return customerManager.fetchCustomers();
    }

}
