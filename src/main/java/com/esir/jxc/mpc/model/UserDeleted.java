package com.esir.jxc.mpc.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "userdeleted")
public class UserDeleted {

    private Date suppressionDate;


}
