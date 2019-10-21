package com.esir.jxc.mpc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "pocket", type="article_added")
public class UserAdded {
    @Id
    private String id;
    private Date creationDate;

}
