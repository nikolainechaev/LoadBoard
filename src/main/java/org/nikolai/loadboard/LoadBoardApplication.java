package org.nikolai.loadboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoadBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoadBoardApplication.class, args);
    }
}