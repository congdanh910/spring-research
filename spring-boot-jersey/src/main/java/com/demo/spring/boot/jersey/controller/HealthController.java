package com.demo.spring.boot.jersey.controller;

import com.demo.spring.boot.jersey.model.Health;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by CongDanh on 10/11/15.
 */
@Component
@Path("/health")
public class HealthController {

    @GET
    @Produces("application/json")
    public Health health() {
        return new Health("Jersey is runing....!");
    }
}
