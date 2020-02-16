package fr.octopus.technight.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FakeNewsProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        String actor1 = exchange.getIn().getHeader("0").toString();
        String actor2 = exchange.getIn().getHeader("1").toString();
        String action = exchange.getIn().getHeader("action").toString();
        exchange.getIn().setBody(actor1 + " " + action + " " + actor2);
    }
}
