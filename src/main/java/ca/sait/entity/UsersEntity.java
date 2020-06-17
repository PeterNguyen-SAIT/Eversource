package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-08 17:39:53
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId()
	private Integer userId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String firstName;
	/**
	 * 
	 */
	private String lastName;
	/**
	 * 
	 */
	private String phoneNumber;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String postalCode;
	/**
	 * 
	 */
	private String email;
	/**
	 * 0:admin, 1: regular customer
	 */
	private Integer isCustomer;
	/**
	 * 0:not active, 1: active
	 */
	private Integer isActive;
	/**
	 * 
	 */
	private Date registerDate;
	/**
	 * 
	 */
	private String note;

}
