package com.example2.service;

import com.example2.dao.IUserDao;
import com.example2.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bin Zhang
 * @create 2020-06-08 9:48 PM
 */
@Service

public class UserService {
    @Autowired
    IUserDao iUserDao;

    public UserEntity getUserById(Integer id){
        return iUserDao.getUserById(id);
    };

    public List<UserEntity> getAllUsers(){
        List<UserEntity> allUser = iUserDao.getAllUsers();
        return allUser;
    }

    public UserEntity loginUser(String email, String password) {
        UserEntity userEntity = iUserDao.loginUser(email, password);
        return userEntity;
    }

    public Integer insertUser(UserEntity userEntity){
        Integer integer = iUserDao.insertUser(userEntity);
        return integer;
    };

    public Integer updateUser(UserEntity userEntity){
        Integer integer = iUserDao.updateUser(userEntity);
        return integer;
    };

    public UserEntity deleteUserById(Integer id){
        UserEntity userById = iUserDao.getUserById(id);
        iUserDao.deleteUserById(id);
        return userById;
    }

}
