package com.example2.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-08 21:09:53
 */
@Data
@TableName("users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;
	private String postalCode;
	private String email;
	private Integer isCustomer;
	private Integer isActive;
	private Date registerDate;
	private String note;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
