package fr.octopus.technight.aggregators;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public class TeaserAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange original, Exchange resource) {
        String fakenews = String.valueOf(original.getIn().getBody());
        String teaser = String.valueOf(resource.getIn().getBody());
        String mergeResult = teaser + fakenews;
        original.getIn().setBody(mergeResult);
        return original;
    }
}
