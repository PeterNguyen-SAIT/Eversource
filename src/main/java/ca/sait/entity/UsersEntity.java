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

	public UsersEntity() {
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Integer getUid() {
		return uid;
	}

	public String getSalt() {
		return salt;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCode() {
		return code;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}
}
