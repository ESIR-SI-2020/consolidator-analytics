package com.esir.jxc.mpc.model.event;

import com.esir.jxc.mpc.model.Event;
import lombok.Data;

import java.util.UUID;

@Data
public class EventArticleCreated {

    private String id;
    private String url;

    public static EventArticleCreated of(Event event) {

        EventArticleCreated eventArticleCreated = new EventArticleCreated();
        eventArticleCreated.setId(UUID.randomUUID().toString());
        eventArticleCreated.setUrl(event.getBody().get("url").asText());

        return eventArticleCreated;
    }
}
