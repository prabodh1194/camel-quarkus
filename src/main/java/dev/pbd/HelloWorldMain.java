package dev.pbd;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class HelloWorldMain extends CamelMainApplication {
    public static void main(String... args) {
        Quarkus.run(CamelMainApplication.class);
    }
}