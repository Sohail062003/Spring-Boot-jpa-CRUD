package com.example.jpademo.services;

import com.example.jpademo.entity.UserClassSpringBoot;
import com.example.jpademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // create
    public UserClassSpringBoot createUser(UserClassSpringBoot user) {
        return userRepository.save(user);
    }

    // get all user
    public List<UserClassSpringBoot> getAllUsers() {
        List<UserClassSpringBoot> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException("no user found");
        }

        return users;

    }

    // get user by id
    public UserClassSpringBoot getById(Long id) {

        if (id == null || id <=0) {
            throw new RuntimeException("Invalid user Id");
        }

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found by : " + id));
    }

    public UserClassSpringBoot updateUser(Long id, UserClassSpringBoot updatedUser) {
        if (id == null || id <=0 ) {
            throw new RuntimeException("Invalid user id");
        }

        UserClassSpringBoot user = getById(id);
        user.setName(updatedUser.getName());

        return userRepository.save(user);

    }


    public String deleteUser(Long id) {
        userRepository.deleteById(id);
       return "user deleted successfully";
    }

}

