package service;

import model.UsersByDay;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserByDayRepository;

import java.util.Date;

public class UsersByDayService {
    @Autowired
    UserByDayRepository usersByDayRepository;
    public void addUser(Date day) {
        UsersByDay usersByDay = usersByDayRepository.findByDay(day);
        if(usersByDay != null) {
            usersByDay.setUserNumber(usersByDay.getUserNumber() + 1);
        } else {
            usersByDay = new UsersByDay();
            usersByDay.setUserNumber(1);
            usersByDay.setDay(day);
        }
        usersByDayRepository.save(usersByDay);
    }
}
