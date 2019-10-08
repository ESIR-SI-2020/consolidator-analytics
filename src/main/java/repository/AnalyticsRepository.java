package repository;

import model.Analytic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnalyticsRepository extends ElasticsearchRepository<Analytic, String> {

    Page<Analytic> findByAuthorsName(String name, Pageable pageable);

    Page<Analytic> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
}

