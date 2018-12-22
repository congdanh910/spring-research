package com.example.couchbase;

import com.example.couchbase.model.Person;
import com.example.couchbase.repository.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    PersonRepository personRepository;

    @Bean
    InitializingBean createPerson() {
        return () -> {
            if (personRepository.count() == 0) {
                Person danh = new Person(UUID.randomUUID().toString(), "Danh", "Ho", new Date());
                Person khanh = new Person(UUID.randomUUID().toString(), "Khanh", "Dang", new Date());
                Person khoinguyen = new Person(UUID.randomUUID().toString(), "Nguyen", "Ho", new Date());

                personRepository.saveAll(Arrays.asList(danh, khanh, khoinguyen));
            }
        };
    }
}

