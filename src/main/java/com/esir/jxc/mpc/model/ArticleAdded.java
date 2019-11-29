package com.esir.jxc.mpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(indexName = "pocket", type="article_added")
public class ArticleAdded {
    @Id
    private String id;
    private Date creationDate;
    private String url;
    private String email;

}
