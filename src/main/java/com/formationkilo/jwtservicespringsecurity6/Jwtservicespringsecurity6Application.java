package com.formationkilo.jwtservicespringsecurity6;

import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppRole;
import com.formationkilo.jwtservicespringsecurity6.config.security.entities.AppUser;
import com.formationkilo.jwtservicespringsecurity6.config.security.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Jwtservicespringsecurity6Application {

    public static void main(String[] args) {
        SpringApplication.run(Jwtservicespringsecurity6Application.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(IAccountService accountService){
        return args -> {
            // creation of Roles
            accountService.addNewRole(new AppRole(null, "USER"));
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));
            //Creation of users
            accountService.addNewUser(new AppUser(null,"user1","0123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin","0123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","0123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","0123",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","0123",new ArrayList<>()));
            //add Roles to Users
            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");

        };
    }
}
