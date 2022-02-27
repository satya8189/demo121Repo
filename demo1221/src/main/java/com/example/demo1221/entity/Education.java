package com.example.demo1221.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "Education_Id")
	    private Long educationId;
	    
	    @Column(name = "YearOfPassing")
	    private Long yearOfPassing;
	    
	    @Column(name = "Qulification")
	    private String qulification;
	    
	    @Column(name = "Percentage")
	    private String percentage;
	    
	   //* @Column(name = "User_Id")
	   // private Long userId;

		@JoinColumn(name = "User_Id")
		@ManyToOne
		private Users users;

		public Long getEducationId() {
			return educationId;
		}

		public void setEducationId(Long educationId) {
			this.educationId = educationId;
		}

		public Long getYearOfPassing() {
			return yearOfPassing;
		}

		public void setYearOfPassing(Long yearOfPassing) {
			this.yearOfPassing = yearOfPassing;
		}

		public String getQulification() {
			return qulification;
		}

		public void setQulification(String qulification) {
			this.qulification = qulification;
		}

		public String getPercentage() {
			return percentage;
		}

		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}

		/*public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}*/

		public Users getUsers() {
			return users;
		}

		public void setUsers(Users users) {
			this.users = users;
		}
		
		
}
