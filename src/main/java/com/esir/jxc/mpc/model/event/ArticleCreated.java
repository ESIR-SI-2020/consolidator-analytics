package com.esir.jxc.mpc.model.event;

import com.esir.jxc.mpc.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ArticleCreated {

    private String id;
    private String url;

    public static ArticleCreated of(Event event) {

        ArticleCreated articleCreated =
                new ArticleCreated(UUID.randomUUID().toString(), event.getMetadata().get("url").asText());

        return articleCreated;
    }
}
