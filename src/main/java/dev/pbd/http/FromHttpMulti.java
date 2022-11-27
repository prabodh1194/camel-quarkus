package dev.pbd.http;

import dev.pbd.http.dto.GreetingData;
import org.apache.camel.builder.RouteBuilder;

public class FromHttpMulti extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("localhost").port("8888");

        from("rest://post:greeting:/{me}").unmarshal().json(GreetingData.class).marshal().json(GreetingData.class)
                .multicast()
                .pipeline()
                    .convertBodyTo(String.class)
                    .to("log:spy")
                .end()
                .pipeline()
                    .to("file:/tmp/data/")
                .end()
        .end();
    }
}
