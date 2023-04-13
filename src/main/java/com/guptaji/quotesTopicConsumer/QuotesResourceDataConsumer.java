package com.guptaji.quotesTopicConsumer;

import com.guptaji.entity.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class QuotesResourceDataConsumer {

    private Random random = new Random();

    @Incoming("incomingTopicNameWillComeFromConfig")
    @Outgoing("outgoingTopicNameWillComeFromConfig")
    public Quote processQuoteDataFromTopic(String quoteRequestData) throws InterruptedException {
        Thread.sleep(200);
        System.out.println("quote request data ---------------- "+ quoteRequestData);
        return new Quote(quoteRequestData, random.nextInt());
    }
}
