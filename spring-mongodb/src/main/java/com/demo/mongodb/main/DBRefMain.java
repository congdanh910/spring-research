package com.demo.mongodb.main;

import com.demo.mongodb.model.Role;
import com.demo.mongodb.model.User;
import com.demo.mongodb.repository.RoleRepository;
import com.demo.mongodb.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by CongDanh on 8/3/15.
 */
public class DBRefMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mongodb-system-servlet.xml");

        // roles
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleManager = new Role("ROßLE_MANAGER");
        Role roleUser = new Role("ROLE_USER");

        // users
        User user = new User("Danh", "Ho", "danhho", "123456");
        user.setRole(roleAdmin);

        User user1 = new User("Khang", "Dang", "khangdang", "123456");
        user1.setRole(roleManager);

        User user2 = new User("Ngan", "Ho", "nganho", "123456");
        user2.setRole(roleUser);

        User user3 = new User("Ngoc", "Ho", "ngocho", "123456");
        user3.setRole(roleUser);

        User user4 = new User("Vuong", "Ho", "vuongho", "123456");
        user4.setRole(roleUser);

        UserRepository userRepository = context.getBean(UserRepository.class);
        RoleRepository roleRepository = context.getBean(RoleRepository.class);

        // save users and roles into db
        /*
        roleRepository.save(roleAdmin);
        roleRepository.save(roleManager);
        roleRepository.save(roleUser);

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        */

        // queries
        Role findByRole = roleRepository.findByRole("ROLE_USER");

        List<User> users = userRepository.findByRole(findByRole);
        for (User us : users) {
            System.out.println(us);
        }
    }
}
