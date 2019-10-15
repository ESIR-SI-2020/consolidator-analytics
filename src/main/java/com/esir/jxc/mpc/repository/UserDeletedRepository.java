package com.esir.jxc.mpc.repository;

import com.esir.jxc.mpc.model.UserDeleted;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeletedRepository extends ElasticsearchRepository<UserDeleted, String> {
    Page<UserDeleted> findAll();
//     UserAdded findByCreationDate(Date creationDate);
}


