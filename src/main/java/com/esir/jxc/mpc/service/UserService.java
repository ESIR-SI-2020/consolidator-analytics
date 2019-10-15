package com.esir.jxc.mpc.service;

import com.esir.jxc.mpc.model.UserAdd;
import org.springframework.beans.factory.annotation.Autowired;
import com.esir.jxc.mpc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository usersRepository;
    public void addUser(UserAdd user) {
        usersRepository.save(user);
    }
}
