package com.esir.jxc.mpc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(indexName = "pocket", type="user_added")
public class UserAdded {
    @Id
    private String id;
    private LocalDate creationDate;
}
