package dev.pbd.http;

import org.apache.camel.builder.RouteBuilder;

public class FromHttp extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("localhost").port("8888");

        rest("/greeting").get().to("direct:greeting");

        from("direct:greeting")
                .log("received a request")
                .setBody(simple("[${date:now:yyyy-MM-dd'T'HH:mm:ss.SSSZ}] Hello, world!"));
    }
}
