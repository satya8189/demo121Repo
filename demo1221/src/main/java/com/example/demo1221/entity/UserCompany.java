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
@Table(name = "user_company")
public class UserCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Comp_Id")
	private Long userCompId;

	@Column(name = "User_Id")
	private Long userId;

	@JoinColumn(name = "User_Id", updatable = false, insertable = false)
	@ManyToOne
	private Users users;

	@Column(name = "Company_Id")
	private Long companyId;

	@JoinColumn(name = "Company_Id", updatable = false, insertable = false)
	@ManyToOne
	private Company company;

	public Long getUserCompId() {
		return userCompId;
	}

	public void setUserCompId(Long userCompId) {
		this.userCompId = userCompId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
}
