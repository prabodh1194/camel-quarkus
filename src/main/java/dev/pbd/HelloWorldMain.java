package dev.pbd;

import io.quarkus.runtime.QuarkusApplication;

@io.quarkus.runtime.annotations.QuarkusMain
public class HelloWorldMain implements QuarkusApplication {
    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello World");
        return 0;
    }
}