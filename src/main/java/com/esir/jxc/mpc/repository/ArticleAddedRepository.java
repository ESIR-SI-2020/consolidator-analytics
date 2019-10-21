package com.esir.jxc.mpc.repository;

import com.esir.jxc.mpc.model.ArticleAdded;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleAddedRepository extends ElasticsearchRepository<ArticleAdded, String> {
    Page<ArticleAdded> findAll();
}


