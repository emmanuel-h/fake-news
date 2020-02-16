package fr.octopus.technight.config;

import fr.octopus.technight.aggregators.TeaserAggregationStrategy;
import fr.octopus.technight.data.Teaser;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FakeNewsConfig extends RouteBuilder {

    private static final String SINGULAR = "singular";

    private final DataSource dataSource;

    private final TeaserAggregationStrategy teaserAggregationStrategy = new TeaserAggregationStrategy();

    public FakeNewsConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure() {

        from("rest:get:generation")
            .bean(NumberGenerator.class)
                .choice()
                .when(simple("${body} == 'singular'"))
                    .setHeader(SINGULAR, constant("1"))
                .otherwise()
                    .setHeader(SINGULAR, constant("0"))
                .end()
            .to("direct:action")
            .to("direct:actor")
            .process("fakeNewsProcessor")
            .enrich("direct:teaser", teaserAggregationStrategy);

        from("direct:action")
            .to("sql:select action_name from action where singular=:#${headers.singular} order by rand() limit 1?outputType=SelectOne")
            .setHeader("action", simple("${body}"));

        from("direct:actor")
                .loop(2)
                    .to("rest:get:technight-couchbase/actor/designation?host=localhost:8081&singular={singular}&bridgeEndpoint=true")
                    .convertBodyTo(String.class)
                    .setHeader(simple("${header[CamelLoopIndex]}").getExpressionText(), simple("${body}"))
                .end();

        from("direct:teaser")
                .bean(Teaser.class);
    }

    static class NumberGenerator {
        public String getNumber() {
            return Math.random() > 0.5 ? SINGULAR : "plural";
        }
    }
}