package com.demo.spring.boot.jersey.model;

/**
 * Created by CongDanh on 10/11/15.
 */
public class Health {
    private String message;

    public Health(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
