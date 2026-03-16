package com.example.jpademo.controller;


import com.example.jpademo.ApiResponse;
import com.example.jpademo.entity.UserClassSpringBoot;
import com.example.jpademo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping
//    public ResponseEntity<UserClassSpringBoot> createUser(@RequestBody UserClassSpringBoot user) {
//        return ResponseEntity.ok( userService.createUser(user));
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserClassSpringBoot>> createUser(@RequestBody UserClassSpringBoot user) {
        UserClassSpringBoot created = userService.createUser(user);
        System.out.println("user Created " + created);
        return ResponseEntity.ok((new ApiResponse<>(
                "Success",
                "user created successfully",
                created
        )));
    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<UserClassSpringBoot>>> getAllUser() {
        List<UserClassSpringBoot> user = userService.getAllUsers();
        return ResponseEntity.ok((new ApiResponse<>(
                "Success",
                "get all User Data",
                 user
        )));
    }

    @GetMapping("/get-user-by/{id}")
    public ResponseEntity<ApiResponse<UserClassSpringBoot>> getById(@PathVariable Long id) {
        UserClassSpringBoot user = userService.getById(id);
        return ResponseEntity.ok((new ApiResponse<>(
            "success",
            "user found successfully",
            user
        )));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserClassSpringBoot>> updateUser(@PathVariable Long id, @RequestBody UserClassSpringBoot user) {
       UserClassSpringBoot updatedUser = userService.updateUser(id, user);

       return ResponseEntity.ok(new ApiResponse<>(
               "success",
               "User updated successfully",
               updatedUser
       ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(
                "Success",
                "User Deleted",
                null
        ));
    }
}
