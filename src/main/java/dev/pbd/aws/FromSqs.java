package dev.pbd.aws;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class FromSqs extends RouteBuilder {
    @ConfigProperty(name = "pbd.queue")
    String message;

    @Override
    public void configure() throws Exception {
        System.out.println(message);
        var url = StaticEndpointBuilders.aws2Sqs("{{pbd.queue}}");
        from(url).to("log:example");
    }
}
