package com.zadaca1.zadaca1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 40)  
    private String email;
     
    @Column(nullable = false, unique = true, length = 10)
    private String password;
     
    @Enumerated(EnumType.STRING)
    private role role;
 
    public User() {}
     
    public User(String email, String password, role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    
}
