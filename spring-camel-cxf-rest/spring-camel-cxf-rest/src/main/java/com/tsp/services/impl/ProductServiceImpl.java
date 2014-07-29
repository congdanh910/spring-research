package com.tsp.services.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.tsp.model.Product;
import com.tsp.services.ProductService;

@Path("/{name}")
public class ProductServiceImpl implements ProductService {

	@Override
	@GET
	@Path("/{id}")
	public Product getProduct(@PathParam("id") String id) {
		return null;
	}

}
