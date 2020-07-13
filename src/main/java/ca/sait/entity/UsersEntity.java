package ca.sait.entity;



import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;



import java.io.Serializable;
import java.sql.Date;
import lombok.Data;



/**
 *
 *
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-07-08 23:13:21
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
	private String token;
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
	 * register date
	 */
	private Date date;
	/**
	 *
	 */
	private String note;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}