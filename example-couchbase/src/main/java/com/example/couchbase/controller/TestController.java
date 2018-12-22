package com.example.couchbase.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/name")
    public String yourHome(@RequestParam String name) {
        return "My home is : " + name;
    }

}
