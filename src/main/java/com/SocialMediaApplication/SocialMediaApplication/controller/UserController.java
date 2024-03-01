package com.SocialMediaApplication.SocialMediaApplication.controller;


import com.SocialMediaApplication.SocialMediaApplication.model.User;
import com.SocialMediaApplication.SocialMediaApplication.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<String> createUser(@Valid @RequestBody User user){

        User savedUser = userDaoService.saveUser(user);
        String uri = ServletUriComponentsBuilder.fromCurrentRequest() //http://localhost:8080/users
                                                .path("/{id}") //http://localhost:8080/users/+ "{id}"
                                                .buildAndExpand(savedUser.getId()).toUriString();
                                                   /*"http://localhost:8080/users/5"*/

        return new ResponseEntity<>(uri, HttpStatus.CREATED);
        //need to add some sort of validation for name and birthDate
        // Spring boot provides you a dependency through which you can validate multiple attributes
        // spring-validation
    }

/*    http://localhost:8080/users/4
    http://localhost:8080/users/5*/

    @DeleteMapping("/users/{id}")
    public Boolean deleteUser(@PathVariable("id") int id){
        return   userDaoService.deleteUserById(id);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        //TODO: There is a bug in this api - you need to find the bug
        User updatedUser = userDaoService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

}
