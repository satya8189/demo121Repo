package com.example.demo1221.model;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserBean {
	
	private Long userId;
	private String firstName;
	private String lastName;
    private String qulification;
    private String email;
    private AddressBean address;
    private String userPwd;
    private List<AccountBean> accountsList;
    private List<EducationBean> educationList;
    
   private String mobileNumber;
    
  
  	private String passportNumber;
    
  
  	private String fatherName;
    
   
    private String motherName;
    
    @JsonIgnore
    private Long age;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getQulification() {
		return qulification;
	}
	public void setQulification(String qulification) {
		this.qulification = qulification;
	}
	
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public List<AccountBean> getAccountsList() {
		return accountsList;
	}
	public void setAccountsList(List<AccountBean> accountsList) {
		this.accountsList = accountsList;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public List<EducationBean> getEducationList() {
		return educationList;
	}
	public void setEducationList(List<EducationBean> educationList) {
		this.educationList = educationList;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}

