package com.esir.jxc.mpc.model.event;

import lombok.Data;

@Data
public class EventUserCreated {

    private String email;
    private String username;
    private String password;


}
