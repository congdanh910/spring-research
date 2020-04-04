package com.example.couchbase.request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PersonCreateModel {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main (String[] args) {
        Map<String, Integer> a = new HashMap<>();
    }
}
