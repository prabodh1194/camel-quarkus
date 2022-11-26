package dev.pbd.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;


public class Camel extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        var url = StaticEndpointBuilders.aws2Sqs("{{pbd.queue}}");
        from(url).to("log:example");
    }
}
