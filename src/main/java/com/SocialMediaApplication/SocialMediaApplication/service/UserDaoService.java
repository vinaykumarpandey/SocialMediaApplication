package com.SocialMediaApplication.SocialMediaApplication.service;

import com.SocialMediaApplication.SocialMediaApplication.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    static{

        userList.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        userList.add(new User(2, "Prasad", LocalDate.now().minusYears(28)));
        userList.add(new User(3, "Rajeev", LocalDate.now().minusYears(20)));
        userList.add(new User(4, "Lokesh", LocalDate.now().minusYears(10)));

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

      return  null;


  }






/*
    public List<User> findAllUsers(); -> Done

    public  User findUserById(int id);  --> Done


    public boolean deleteUser(int id);

    public User updateUser(int id, User user);

    public User createUser(User user);


    */


}
