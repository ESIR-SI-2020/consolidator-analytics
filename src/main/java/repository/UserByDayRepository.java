package repository;

import model.UsersByDay;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;

public interface UserByDayRepository extends ElasticsearchRepository<UsersByDay, String> {
     UsersByDay findByDay(Date day);
}
