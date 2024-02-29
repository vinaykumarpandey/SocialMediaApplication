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

    public Boolean deleteUserById(int id) {

        for(User user: userList){
            if(user.getId() == id){
                userList.remove(user);
                return true;
            }

        }

        throw new UserNotFoundException("User not found with the given id: " +id);

    }

    public User updateUser(User newUser){
        /*
        * 1. get the id from the user object
        * 2. check if the id is matching in userlist
        * 3. once you get the corresponding user object of the id
        * 4. update that user
        * */

      //  get the id from the user object

        for(User existingUser: userList){
            if(existingUser.getId() == newUser.getId()){
                userList.set(existingUser.getId(), newUser);
                return newUser;
            }

        }

        throw new UserNotFoundException("User not found with the given id: " +newUser.getId());


    }






/*
    public List<User> findAllUsers(); -> Done

    public  User findUserById(int id);  --> Done


    public boolean deleteUser(int id); --> working on

    public User updateUser(int id, User user);

    public User createUser(User user); --> Done


    */


}
