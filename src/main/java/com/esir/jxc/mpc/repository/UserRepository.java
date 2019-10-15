package com.esir.jxc.mpc.repository;

import com.esir.jxc.mpc.model.UserAdd;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserAdd, String> {
    Page<UserAdd> findAll();
//     UserAdd findByCreationDate(Date creationDate);
}
