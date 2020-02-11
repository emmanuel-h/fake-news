package fr.octopus.technight.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FakeNewsConfig extends RouteBuilder {

    @Override
    public void configure() {
        from("rest:get:generation")
            .bean(NumberGenerator.class)
                .choice()
                .when(simple("${body} == 'singular'"))
                    .log("yay")
                .otherwise()
                    .log("nay")
                .end();
    }

    static class NumberGenerator {
        public String getNumber() {
            return Math.random() > 0.5 ? "singular" : "plural";
        }
    }
}