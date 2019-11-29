package com.esir.jxc.mpc.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private String id;
    private String type;
    private ObjectNode metadata;
    private LocalDateTime createdAt;

}