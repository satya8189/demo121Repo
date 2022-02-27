package com.example.demo1221.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersdetails")
public class UserExt implements Serializable {
	
	  
    @Id
    @OneToOne
    @JoinColumn(name = "User_Id")
    private Users users;
	
    @Column(name = "Mobile_Number")
	private String mobileNumber;
    
    @Column(name = "Passport_Number")
  	private String passportNumber;
    
    @Column(name = "Father_Name")
  	private String fatherName;
    
    @Column(name = "Mother_Name")
    private String motherName;
  
  
	
	
	   public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
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
