package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.UserAdd;
import com.esir.jxc.mpc.repository.UserRepository;
import com.esir.jxc.mpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Application starting...");

        };
    }
}
