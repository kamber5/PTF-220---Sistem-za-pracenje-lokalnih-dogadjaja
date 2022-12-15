package com.zadaca1.zadaca1;

import java.util.List;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class DatabaseLoader {
 
    private UserRepository repo;
     
    public DatabaseLoader(UserRepository repo) {
        this.repo = repo;
    }
 
    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            User user1 = new User("a@gmail.com", "a", role.ADMIN);
            User user2 = new User("c@gmail.net", "c", role.USER);
             
            repo.saveAll(List.of(user1, user2));
             
            System.out.println("Database initialized");
        };
    }
}