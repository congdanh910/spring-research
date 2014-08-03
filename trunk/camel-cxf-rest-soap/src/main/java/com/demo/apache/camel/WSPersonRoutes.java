package com.demo.apache.camel;

import org.apache.camel.builder.RouteBuilder;

public class WSPersonRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		configurePersonRoute();
	}

	private void configurePersonRoute() {
		from("direct:hello:vin:validateVin").log("Request: name=${header.name}").choice()
			.when(header("brand").isEqualTo("danh")).to("direct:hello:vin:validateVin:nissan")
			.when(header("brand").isEqualTo("khanh")).to("direct:hello:vin:validateVin:renault");
	}

}
