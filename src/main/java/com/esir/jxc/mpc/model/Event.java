package com.esir.jxc.mpc.model;

import com.esir.jxc.mpc.model.event.EventUserCreated;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;

@Data
public class Event {
    private String eventName;
    private ObjectNode body;

    public EventUserCreated toEventUserCreated() {
        EventUserCreated eventUserCreated = new EventUserCreated();
        eventUserCreated.setEmail(this.getBody().get("email").textValue());
        eventUserCreated.setPassword(this.getBody().get("password").textValue());
        eventUserCreated.setUsername(this.getBody().get("username").textValue());
        return eventUserCreated;
    }

}
