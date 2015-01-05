package com.demo.cxfAndCamel.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/{region}")
@Produces("application/json")
public class CxfServices {

	@GET
	@Path("/getAllUser/")
	public List<String> getAllUser() {
		return null;
	}

}
