package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.event.ArticleCreated;
import com.esir.jxc.mpc.utils.DateUtils;
import fr.esir.jxc.domain.events.Event;
import fr.esir.jxc.domain.models.analytics.ArticleAdded;
import fr.esir.jxc.domain.models.analytics.UserAdded;
import fr.esir.jxc.elasticsearch.repositories.ArticleAddedRepository;
import fr.esir.jxc.elasticsearch.repositories.UserAddedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventRouting {

    @Autowired
    UserAddedRepository userAddedRepository;
    @Autowired
    ArticleAddedRepository articleAddedRepository;

    public void processEvent(Event event) {

        switch (event.getType()) {
            case "USER_ADDED":
                onUserAdded(event);
                break;
            case "ARTICLE_ADDED":
                onArticleAdded(event);
                break;
        }
    }

    private void onUserAdded(Event event) {
        UserAdded userAdded = new UserAdded(event.getId(), DateUtils.getDate());
        userAddedRepository.save(userAdded);
    }

    private void onArticleAdded(Event event) {
        ArticleCreated articleCreated = ArticleCreated.of(event);
        ArticleAdded articleAdded =
                new ArticleAdded(articleCreated.getId(), DateUtils.getDate(), articleCreated.getUrl(),
                        articleCreated.getEmail());
        articleAddedRepository.save(articleAdded);
    }
}
