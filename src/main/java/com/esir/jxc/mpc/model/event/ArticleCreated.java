package com.esir.jxc.mpc.model.event;

import com.esir.jxc.mpc.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleCreated {

    private String id;
    private String url;
    private String email;

    public static ArticleCreated of(Event event) {

        return new ArticleCreated(event.getId(), event.getMetadata().get("url").asText(),
                event.getMetadata().get("email").asText());
    }
}
