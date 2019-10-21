package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.Event;
import com.esir.jxc.mpc.model.UserAdded;
import com.esir.jxc.mpc.model.ArticleAdded;
import com.esir.jxc.mpc.model.event.EventArticleCreated;
import com.esir.jxc.mpc.repository.ArticleAddedRepository;
import com.esir.jxc.mpc.repository.UserAddedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class EventRouting {
    @Autowired
    UserAddedRepository userAddedRepository;
    @Autowired
    ArticleAddedRepository articleAddedRepository;

    public void processEvent(Event event) {
        if (event.getEventName().equals("USER_ADDED")) {
            UserAdded userAdded = new UserAdded();
            userAdded.setCreationDate(getDate());
            userAddedRepository.save(userAdded);
        }

        else if (event.getEventName().equals("ARTICLE_ADDED")) {

            EventArticleCreated eventArticleCreated = EventArticleCreated.of(event);
            ArticleAdded articleAdded = new ArticleAdded();
            articleAdded.setCreationDate(getDate());
            articleAdded.setUrl(eventArticleCreated.getUrl());
            articleAddedRepository.save(articleAdded);

        }
    }

    private Date getDate(){
        LocalDateTime now = LocalDateTime.now();
        Calendar cal = Calendar.getInstance();
        cal.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        return cal.getTime();
    }
}
