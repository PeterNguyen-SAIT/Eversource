package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-23 11:04:00
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer uid;
	/**
	 * 
	 */
	private String uname;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String salt;
	/**
	 * 
	 */
	private String fname;
	/**
	 * 
	 */
	private String lname;
	/**
	 * 
	 */
	private String phone;
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
	private String code;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String role;
	/**
	 * active or not
	 */
	private String status;
	/**
	 * register
	 */
	private Date date;
	/**
	 * 
	 */
	private String note;

}
