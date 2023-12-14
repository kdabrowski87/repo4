package com.kd1987.rest.webservices.javarestapi1.helloworld;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;


public class HelloWorldBean {

    private String  message;
    public HelloWorldBean(String helloWorldRestApi) {
        this.message = helloWorldRestApi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
