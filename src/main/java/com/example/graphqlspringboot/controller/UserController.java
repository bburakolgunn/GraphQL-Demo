package com.example.graphqlspringboot.controller;

import com.example.graphqlspringboot.Service.UserService;
import com.example.graphqlspringboot.model.User;
import com.example.graphqlspringboot.model.UserRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @QueryMapping
    List<User> getAllUsers() {
    return userService.getAllUsers();
    }

    @QueryMapping
    User getUserById(@Argument Long id) { //Argument ile parametre alınır.
    return userService.getUserById(id);
    }


    @MutationMapping
    User createUser(@Argument UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @MutationMapping
    User updateUser(@Argument UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    Boolean deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return  true;
    }


}
