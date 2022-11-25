package dev.pbd.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;


public class Camel extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        var url = StaticEndpointBuilders.aws2Sqs("test_test");
        from(url).process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getMessage().getBody().toString());
            }
        });
    }
}
