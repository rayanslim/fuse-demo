package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class RouteA extends RouteBuilder{

	@Override
	public void configure() throws Exception {
                from("direct:a")  
                .routeId("a")
                .setHeader("headerId").simple(UUID.randomUUID().toString()) //monitors every processing step.
                .setBody(simple("body"))   
                .log("hello from route a")
                .end();   
	}
}