package com.ctl.sbt.demo.manager;

import org.springframework.stereotype.Component;

@Component
public class GreetingManager {

    private String message;

    public String getMessage() {
        return "Hello "+message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

