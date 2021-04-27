package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Processor;
import java.util.UUID;

import org.apache.camel.Exchange;


@Component
public class RouteF extends RouteBuilder{

	@Override
	public void configure() throws Exception {

                from("direct:f")
                .routeId("f")
                .setHeader("headerId").simple(UUID.randomUUID().toString())
                .setBody(simple("body")) 
                .to("jms:SampleQueue?exchangePattern=InOut");

                from("jms:SampleQueue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        try {
                            Thread.sleep(3000);
                        } catch(InterruptedException ex) {                                             
                            Thread.currentThread().interrupt();
                        }
                    }
                })
                .log("processing complete.")
                .end();
	}
}