package com.example2.controllers;

import com.example2.entity.UserEntity;
import com.example2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bin Zhang
 * @create 2020-06-08 9:57 PM
 */
@RestController
public class MyControllerTest {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/all")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/user/insert")
    public UserEntity insertUser(UserEntity userEntity){
        userService.insertUser(userEntity);
        return userEntity;
    }

    @GetMapping("/user/update")
    public UserEntity updateUser(UserEntity userEntity){
        userService.updateUser(userEntity);
        return userEntity;
    }

    @GetMapping("/user/delete/{id}")
    public UserEntity deleteUserById(@PathVariable Integer id){
        UserEntity userEntity = userService.deleteUserById(id);
        return userEntity;
    }
}
