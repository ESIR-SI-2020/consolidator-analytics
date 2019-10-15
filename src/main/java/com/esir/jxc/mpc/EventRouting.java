package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.Event;
import com.esir.jxc.mpc.model.UserAdd;
import com.esir.jxc.mpc.repository.UserRepository;
import com.esir.jxc.mpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;

@Component
public class EventRouting {
    @Autowired
    UserRepository userRepository;

    public void processEvent(Event event) {
        if(event.getName().equals("add")) {
            LocalDateTime now = LocalDateTime.now();
            Calendar cal = Calendar.getInstance();
            cal.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
            UserAdd user = new UserAdd();
            user.setCreationDate(cal.getTime());
            userRepository.save(user);
        }
    }
}
