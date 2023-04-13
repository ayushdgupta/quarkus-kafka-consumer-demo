package com.guptaji.deserializations;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.acme.kafka.quarkus.Picture;

public class CinemaDeserializer extends ObjectMapperDeserializer<Picture> {
    public CinemaDeserializer() {
        super(Picture.class);
    }
}
