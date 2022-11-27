package dev.pbd.aws;

import dev.pbd.aws.dto.Event;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.endpoint.StaticEndpointBuilders;
import org.apache.camel.component.aws2.sqs.Sqs2Constants;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class FromSqs extends RouteBuilder {
    @ConfigProperty(name = "pbd.queue")
    String message;

    @Override
    public void configure() throws Exception {
        System.out.println(message);
        var url = StaticEndpointBuilders.aws2Sqs("{{pbd.queue}}").deleteAfterRead(false);
        from(url)
                .unmarshal()
                .json(Event.class)
                .to("log:example")
                .split(header(Sqs2Constants.RECEIPT_HANDLE))
                .process(ex -> {

                })
                .log("log:headers");
    }
}
