package com.demo.cxfAndCamel.camel;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CxfCamelRoutes extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		/*
		 * cxfWS is bean which was declared in servlet-context.xml
		 * .to("direct:cxf:getAllUser") ==> only one method
		 * .recipientList(simple("direct:cxf:${header.operationName}")) ==> can work with many method
		 */
		from("cxfrs:bean:cxfWS?bindingStyle=SimpleConsumer").recipientList(
				simple("direct:cxf:${header.operationName}")).stopOnException();
		/*
		 * direct:cxf 
		 * direct is camel keyword
		 * cxf is bean which was declared in servlet-context.xml 
		 */
		from("direct:cxf:getAllUser").log("Request region=${header.region}").choice().
		when(header("region").isEqualTo("vn")).to("direct:cxf:vn:getAllUser")
		.when(header("region").isEqualTo("us")).to("direct:cxf:us:getAllUser");

		from("direct:cxf:vn:getAllUser").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Response response = Response.status(Status.OK)
						.type(MediaType.APPLICATION_JSON_TYPE)
						.entity("Hello, this is getAllUser with VN").build();
				exchange.getOut().setBody(response);
			}
		});

		from("direct:cxf:us:getAllUser").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Response response = Response.status(Status.OK)
						.type(MediaType.APPLICATION_JSON_TYPE)
						.entity("Hello, this is getAllUser with US").build();
				exchange.getOut().setBody(response);
			}
		});

	}

}
