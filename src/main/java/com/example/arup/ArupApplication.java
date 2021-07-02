package com.example.arup;

import com.example.arup.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArupApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArupApplication.class, args);
    }

}
