package com.example2.dao;

import com.example2.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Bin Zhang
 * @create 2020-06-08 9:29 PM
 */
@Mapper
public interface IUserDao {
    @Select("select * from users where user_id=#{id}")
    UserEntity getUserById(Integer id);

    @Select("select * from users")
    List<UserEntity> getAllUsers();

    @Select("select * from users where email=#{email} and password=#{password}")
    UserEntity loginUser(String email, String password);

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into users (user_name, password, first_name, last_name, phone_number, address, city, postal_code, email, is_customer, is_active, register_date, note) " +
            "values (#{userName}, #{password}, #{firstName}, #{lastName}, #{phoneNumber}, #{address}, #{city}, #{postalCode}, #{email}, #{isCustomer}, #{isActive}, #{registerDate}, #{note})")
    Integer insertUser(UserEntity userEntity);

    @Delete("delete from users where user_id=#{id}")
    Integer deleteUserById(Integer id);

    @Update("update users set user_name=#{userName}, password=#{password}, first_name=#{firstName}, last_name=#{lastName}, phone_number=#{phoneNumber}, address=#{address}, city=#{city}, postal_code=#{postalCode}, email=#{email}, is_customer=#{isCustomer}, is_active=#{isActive},register_date=#{registerDate},note=#{note} where user_id=#{userId}")
    Integer updateUser(UserEntity userEntity);

}
