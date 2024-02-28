package com.SocialMediaApplication.SocialMediaApplication.service;

import com.SocialMediaApplication.SocialMediaApplication.exception.UserNotFoundException;
import com.SocialMediaApplication.SocialMediaApplication.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();
    private static int idCount;

    static{

        userList.add(new User(idCount++, "Adam", LocalDate.now().minusYears(30)));
        userList.add(new User( idCount++, "Prasad", LocalDate.now().minusYears(28)));
        userList.add(new User(idCount++, "Rajeev", LocalDate.now().minusYears(20)));
        userList.add(new User(idCount++, "Lokesh", LocalDate.now().minusYears(10)));

    }

  public  List<User> findAllUsers(){
    return userList;
  }

  public User findUserById(int id){

        for(User user:userList ){
            if(user.getId() == id){
                return user;
            }
        }

     throw new UserNotFoundException("User not found with the given id: " +id);


  }

  public User saveUser(User user){

        user.setId(idCount++);
        userList.add(user);

        return user;

  }






/*
    public List<User> findAllUsers(); -> Done

    public  User findUserById(int id);  --> Done


    public boolean deleteUser(int id);

    public User updateUser(int id, User user);

    public User createUser(User user); --> Done


    */


}
