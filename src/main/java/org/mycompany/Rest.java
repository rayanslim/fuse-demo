package org.mycompany;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Rest extends RouteBuilder{

	@Override
	public void configure() throws Exception {

        restConfiguration().component("undertow").scheme("http").port("8443").bindingMode(RestBindingMode.auto);
        
        rest("/a").get().to("direct:a");    
    
        rest("/b").get().to("direct:b");

        rest("/c").get().to("direct:c");

        rest("/d").get().to("direct:d");

        rest("/e").get().to("direct:e");

        rest("/f").get().to("direct:f");

	}
}