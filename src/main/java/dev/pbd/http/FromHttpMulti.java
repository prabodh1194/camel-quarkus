package dev.pbd.http;

import dev.pbd.GreetingData;
import org.apache.camel.builder.RouteBuilder;

public class FromHttpMulti extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("localhost").port("8888");

        from("rest://post:greeting:/{me}").multicast()
                .pipeline()
                    .unmarshal()
                    .json(GreetingData.class)
                    .process(ex -> {
                        var msg = ex.getMessage();
                        var bod = msg.getBody(GreetingData.class);
                        ex.getMessage().setBody(bod);
                    })
                    .to("log:spy")
                .end()
                .pipeline()
                    .to("file:/tmp/data/")
                .end()
        .end();
    }
}
