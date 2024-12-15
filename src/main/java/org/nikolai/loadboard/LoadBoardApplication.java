package org.nikolai.loadboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.nikolai.loadboard.repository")
public class LoadBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBoardApplication.class, args);
    }
}
