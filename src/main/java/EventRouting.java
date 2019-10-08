import model.Event;
import org.elasticsearch.common.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import service.AnalyticsService;
import service.UsersByDayService;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class EventRouting {
    @Autowired
    UsersByDayService usersByDayService;

    public void processEvent(Event event) {
        if(event.getName() == "add") {
            LocalDateTime now = LocalDateTime.now();
            Calendar cal = Calendar.getInstance();
            cal.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
            usersByDayService.addUser(cal.getTime());
        }
    }
}
