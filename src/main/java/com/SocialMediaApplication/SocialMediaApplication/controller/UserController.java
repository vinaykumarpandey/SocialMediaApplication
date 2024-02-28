package com.SocialMediaApplication.SocialMediaApplication.controller;


import com.SocialMediaApplication.SocialMediaApplication.model.User;
import com.SocialMediaApplication.SocialMediaApplication.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;


    @GetMapping("/users") //All the users
    public List<User> provideAllUsers(){

        return  userDaoService.findAllUsers();
    }

     //To fetch only one user whose Id I am providing -

    @GetMapping("/users/{id}") //Fetch user by its id
    public User provideOneUser(@PathVariable("id") int id){
      return   userDaoService.findUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userDaoService.saveUser(user);
    }

}
