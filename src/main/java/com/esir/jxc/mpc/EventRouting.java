package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.ArticleAdded;
import com.esir.jxc.mpc.model.Event;
import com.esir.jxc.mpc.model.UserAdded;
import com.esir.jxc.mpc.model.event.ArticleCreated;
import com.esir.jxc.mpc.repository.ArticleAddedRepository;
import com.esir.jxc.mpc.repository.UserAddedRepository;
import com.esir.jxc.mpc.utils.DateUtils;
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
                onUserAdded();
                break;
            case "ARTICLE_ADDED":
                onArticleAdded(event);
                break;
        }
    }

    private void onUserAdded() {
        UserAdded userAdded = new UserAdded(UUID.randomUUID().toString(), DateUtils.getDate());
        userAddedRepository.save(userAdded);
    }

    private void onArticleAdded(Event event) {
        ArticleCreated articleCreated = ArticleCreated.of(event);
        ArticleAdded articleAdded =
                new ArticleAdded(UUID.randomUUID().toString(), DateUtils.getDate(), articleCreated.getUrl(),
                        articleCreated.getEmail());
        articleAddedRepository.save(articleAdded);
    }
}
