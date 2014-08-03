package com.demo.apache.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/{routerName}/{locale}")
@Produces("application/json")
public class WSPersonService implements PersonService {

	@GET
	@Path("/{name}")
	@Produces("application/json")
	public String hello(@PathParam("name") String name) {
		System.out.println("Name : " + name);
		return null;
	}

}
