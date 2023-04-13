package com.guptaji.quotesTopicConsumer;

import com.guptaji.entity.Quote;
import io.smallrye.mutiny.Multi;
import org.acme.kafka.quarkus.Picture;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/consumed-movies")
public class ConsumedMovieResource {

//    @Inject
//    @Channel("movies-from-kafka")
//    Multi<Picture> pictures;
//
//    @GET
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    @RestStreamElementType(MediaType.TEXT_PLAIN)
//    public Multi<String> stream() {
//        System.out.println("movie title ------------- ");
//        Multi<String> map = pictures.map(temp -> String.format("'%s' from %s", temp.getTitle(), temp.getYear()));
//        System.out.println(map);
//        return map;
//    }

    @Incoming("movies-from-kafka")
    public void processCinemaDataTopic(Picture picturesData) throws InterruptedException {
        Thread.sleep(200);
        System.out.println("pictures request data ---------------- "+ picturesData.getTitle());
    }
}
