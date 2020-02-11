package fr.octopus.technight.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FakeNewsConfig extends RouteBuilder {

    @Override
    public void configure() {
        from("rest:get:generation")
                .log("yay");
    }
}
