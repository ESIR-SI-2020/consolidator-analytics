package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.Event;
import com.esir.jxc.mpc.model.UserAdded;
import com.esir.jxc.mpc.model.UserDeleted;
import com.esir.jxc.mpc.repository.UserRepository;
import com.esir.jxc.mpc.repository.UserDeletedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class EventRouting {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDeletedRepository userDeletedRepository;

    public void processEvent(Event event) {
        if (event.getEventName().equals("USER_ADDED")) {
            UserAdded userAdded = new UserAdded();
            userAdded.setCreationDate(getDate());
            userRepository.save(userAdded);
        }
        else if (event.getEventName().equals("USER_DELETED")) {
            UserDeleted userDeleted = new UserDeleted();
            userDeleted.setSuppressionDate(getDate());
            userDeletedRepository.save(userDeleted);
        }
    }
    private Date getDate(){
        LocalDateTime now = LocalDateTime.now();
        Calendar cal = Calendar.getInstance();
        cal.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        return cal.getTime();
    }
}
