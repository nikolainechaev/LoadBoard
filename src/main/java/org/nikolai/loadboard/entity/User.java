package org.nikolai.loadboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users") // Use 'users' instead of 'user'
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; // 'CARRIER' or 'BROKER'

    @OneToMany(mappedBy = "bookedBy")
    private List<Load> bookedLoads;


}
