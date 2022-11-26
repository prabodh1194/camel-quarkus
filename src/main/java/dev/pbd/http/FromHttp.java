package dev.pbd.http;

import org.apache.camel.builder.RouteBuilder;

public class FromHttp extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("netty-http://http://localhost:8888/greeting")
                .log("recieved a request")
                .setBody(simple("[${date:now:yyyy-MM-dd'T'HH:mm:ss.SSSZ}] Hello, world!"));
    }
}
