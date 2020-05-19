package com.ctl.sbt.demo.rest;

import com.ctl.sbt.demo.manager.GreetingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    GreetingManager greetingManager;

    @GetMapping("/plain-hello")
    public ResponseEntity<String> greet(){
        return new ResponseEntity("Hello Springboot!!", HttpStatus.OK);
    }

    @GetMapping("/di-hello")
    public ResponseEntity<String> geeting(){
        greetingManager.setMessage("Springboot!!");
        return new ResponseEntity(greetingManager.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/config-customer")
    public ResponseEntity<String> configCustomer(){
        return new ResponseEntity(greetingManager.getMessage(), HttpStatus.OK);
    }

}
