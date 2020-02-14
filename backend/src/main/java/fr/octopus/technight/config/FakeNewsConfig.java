package fr.octopus.technight.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FakeNewsConfig extends RouteBuilder {

    private final DataSource dataSource;

    public FakeNewsConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure() {

        from("rest:get:generation")
            .bean(NumberGenerator.class)
                .choice()
                .when(simple("${body} == 'singular'"))
                    .setHeader("singular", constant("1"))
                .otherwise()
                    .setHeader("singular", constant("0"))
                .end()
            .to("direct:database");

        from("direct:database")
            .to("sql:select action_name from action where singular=:#${headers.singular} order by rand() limit 1?outputType=SelectOne")
            .log("${body}")
            .log("${headers}");
    }

    static class NumberGenerator {
        public String getNumber() {
            return Math.random() > 0.5 ? "singular" : "plural";
        }
    }
}