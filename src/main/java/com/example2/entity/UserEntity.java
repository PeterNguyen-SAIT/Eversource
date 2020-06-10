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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(Integer isCustomer) {
		this.isCustomer = isCustomer;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", postalCode='" + postalCode + '\'' +
				", email='" + email + '\'' +
				", isCustomer=" + isCustomer +
				", isActive=" + isActive +
				", registerDate=" + registerDate +
				", note='" + note + '\'' +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
