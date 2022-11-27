package dev.pbd.http;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class FromHttpMulti extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("localhost").port("8888");

        from("rest://post:greeting:/{me}").multicast()
                .pipeline()
                    .process(new Processor() {
                        @Override
                        public void process(Exchange exchange) throws Exception {
                            var msg = exchange.getMessage();
                        }
                    })
                    .to("log:spy")
                .end()
                .pipeline()
                    .to("file:/tmp/data/")
                .end()
        .end();
    }
}
