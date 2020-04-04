package com.example.couchbase;

import com.example.couchbase.model.Person;
import com.example.couchbase.repository.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

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

                Map<String, String> c1 = new HashMap<>();
                c1.put("name", "IT consultant");
//                c1.put("address", "Ho Chi Minh");
//                c1.put("year", "2019");
//                c1.put("expired", "2022");
//                c1.put("level", "Middle");


                Map<String, String> c2 = new HashMap<>();
                c2.put("name", "Sale manager");
//                c2.put("address", "Binh Tan");
//                c2.put("year", "2018");
//                c2.put("expired", "2025");
//                c2.put("level", "Senior");

                Map<String, String> c2_1 = new HashMap<>();
                c2_1.put("name", "Children management certification");
//                c2_1.put("address", "District 7");
//                c2_1.put("year", "2018");
//                c2_1.put("expired", "2025");
//                c2_1.put("level", "Middle");

                Map<String, String> c3 = new HashMap<>();
                c3.put("name", "Information Technology Master");
//                c3.put("address", "Khoa Hoc Tu Nhien, Thanh Pho Ho Chi Minh");
//                c3.put("year", "2015");
//                c3.put("expired", "2035");
//                c3.put("level", "Latest");


                Map<String, String> c4 = new HashMap<>();
                c4.put("name", "CCNA certification");
//                c4.put("address", "United states of america");
//                c4.put("year", "2015");
//                c4.put("expired", "2035");
//                c4.put("level", "Senior");


                Map<String, String> c5 = new HashMap<>();
                c5.put("name", "Spring master");
//                c5.put("address", "Singapore");
//                c5.put("year", "2017");
//                c5.put("expired", "2025");
//                c5.put("level", "Senior");

                Person danh = new Person(UUID.randomUUID().toString(), "Danh", "Ho", new Date());
                List<Map<String, String>> danhCerts = new ArrayList<>();
                danhCerts.add(c5);
                danhCerts.add(c4);
                danhCerts.add(c3);
                danh.setCertifications(danhCerts);


                Person khanh = new Person(UUID.randomUUID().toString(), "Khanh", "Dang", new Date());
                List<Map<String, String>> khanhCerts = new ArrayList<>();
                khanhCerts.add(c2);
                khanhCerts.add(c2_1);
                khanhCerts.add(c1);
                khanh.setCertifications(khanhCerts);

                Person khoinguyen = new Person(UUID.randomUUID().toString(), "Nguyen", "Ho", new Date());
                List<Map<String, String>> khoinguyenCerts = new ArrayList<>();
                khoinguyenCerts.add(c5);
                khoinguyenCerts.add(c3);
                khoinguyen.setCertifications(khoinguyenCerts);

                personRepository.saveAll(Arrays.asList(danh, khanh, khoinguyen));
            }
        };
    }
}

