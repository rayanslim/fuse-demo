package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class RouteB extends RouteBuilder{

	@Override
	public void configure() throws Exception {
                from("direct:b")
                .routeId("b")  
                .setHeader("headerId").simple(UUID.randomUUID().toString())
                .setBody(simple("body")) 
                .log("hello from route B")
                .end();
	}
}