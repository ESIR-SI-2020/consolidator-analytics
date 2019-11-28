package com.esir.jxc.mpc.model;

import com.esir.jxc.mpc.model.event.UserCreated;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

@Data
public class Event {
    private String eventName;
    private ObjectNode body;
}
