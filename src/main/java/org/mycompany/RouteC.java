package org.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import java.util.UUID;

public class RouteC extends RouteBuilder {
    @Override
    public void configure() throws Exception {

                from("direct:c")  
                .routeId("c")
                .setHeader("headerId").simple(UUID.randomUUID().toString())
                .setBody(simple("body")) 
                .process(new Processor(){ 
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        throw new IllegalArgumentException();
                    }
                })
                .end();
        }
    }