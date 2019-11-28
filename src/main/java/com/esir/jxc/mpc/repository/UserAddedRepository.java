package com.esir.jxc.mpc.repository;

import com.esir.jxc.mpc.model.UserAdded;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddedRepository extends ElasticsearchRepository<UserAdded, String> {
    Page<UserAdded> findAll();
}


