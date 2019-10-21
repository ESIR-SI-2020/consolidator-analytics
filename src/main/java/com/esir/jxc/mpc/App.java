package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.UserAdded;
import com.esir.jxc.mpc.repository.UserAddedRepository;
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
    UserAddedRepository userAddedRepository;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            UserAdded user = new UserAdded();
//            userService.addUser(user);
//            System.out.println("user added");
            List<UserAdded> users = userAddedRepository.findAll().getContent();
            System.out.println(users);

        };
    }
}
