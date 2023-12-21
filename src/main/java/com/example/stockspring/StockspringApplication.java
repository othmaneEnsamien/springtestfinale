package com.example.stockspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockspringApplication.class, args);
    }

}
