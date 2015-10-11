package com.demo.spring.boot.jersey.controller;

import com.demo.spring.boot.jersey.model.Staff;
import com.demo.spring.boot.jersey.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by CongDanh on 10/11/15.
 */
@Component
@Path(("/staff"))
public class StaffController {

    @Autowired
    private StaffServices staffServices;

    @GET
    @Path("/list")
    @Produces("application/json")
    public List<Staff> list() {
        return staffServices.fetchAll();
    }
}
