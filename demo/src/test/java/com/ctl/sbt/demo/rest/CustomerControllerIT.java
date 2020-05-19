package com.ctl.sbt.demo.rest;

import com.ctl.sbt.demo.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void createCust() throws MalformedURLException, JsonProcessingException {
        URL createCustUrl = new URL("http://localhost:"+port+"/demo/customer/create");

        Customer customer = new Customer();
        customer.setFirstName("Manju");

        ResponseEntity<String> customerResp = restTemplate.postForEntity(createCustUrl.toString(), customer, String.class);

        JsonNode customerRoot= objectMapper.readTree(customerResp.getBody());

        log.info("resp id: "+customerRoot.path("id"));
        Assert.notNull(customerRoot.path("id"),"ID cannot be null after save");
    }

    @Test
    void fetchAllCustomers() {
    }
}