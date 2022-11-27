package dev.pbd.http;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.netty.http.NettyHttpMessage;

public class FromHttp extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("netty-http").host("localhost").port("8888");

        from("rest://get:greeting:/{me}/{lang}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        var httpMsg = exchange.getMessage(NettyHttpMessage.class);
                        var hdrs = httpMsg.getHeaders();

                        log.info((String) hdrs.get("me"));
                        log.info((String) hdrs.get("lang"));
                        log.info((String) hdrs.getOrDefault("z", "10"));
                    }
                })
                .log("received a request")
                .setBody(simple("[${date:now:yyyy-MM-dd'T'HH:mm:ss.SSSZ}] Hello, world!"));
    }
}
