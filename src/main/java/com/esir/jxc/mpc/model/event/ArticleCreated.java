package com.esir.jxc.mpc.model.event;

import fr.esir.jxc.domain.events.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleCreated {

    private String id;
    private String url;
    private String email;

    public static ArticleCreated of(Event event) {

        ArticleCreated articleCreated =
                new ArticleCreated(event.getId(), event.getMetadata().get("articleUrl").asText(),
                        event.getMetadata().get("email").asText());




        return articleCreated;
    }
}
