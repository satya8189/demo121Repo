package com.example.demo1221.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "users")
public class Users  implements Serializable{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "User_Id")
	    private Long userId;
	 
	    
	    @Column(name = "First_Name")
	    private String firstName;
	    
	    @Column(name = "Last_Name")
	    private String lastName;
	 
	    @Column(name = "Email")
	    private String email;
	    
	    
	    @Column(name = "Password")
	 	   private String userPwd;
	    
	    @JsonIgnore
	    @OneToMany(mappedBy = "users",  cascade = CascadeType.ALL, orphanRemoval = true ,fetch=FetchType.EAGER)
	    private List<Education> educations;
	  
	    @JsonIgnore
	    @OneToOne(mappedBy ="users", cascade = CascadeType.ALL, orphanRemoval = true ,fetch=FetchType.EAGER)
	     UserExt userExt;
	    
	    
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


		public List<Education> getEducations() {
			return educations;
		}


		public void setEducations(List<Education> educations) {
			this.educations = educations;
		}


		public UserExt getUserExt() {
			return userExt;
		}


		public void setUserExt(UserExt userExt) {
			this.userExt = userExt;
		}
	    
	  
	    
}
	