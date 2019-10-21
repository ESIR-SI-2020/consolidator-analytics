package com.esir.jxc.mpc.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "articleadded")
public class ArticleAdded {

    private Date creationDate;

}
