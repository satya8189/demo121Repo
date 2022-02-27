package com.example.demo1221.model;

import java.util.List;

public class ResponseBean {
	
	private String dbName;
	private List<UserBean> userList;
	private String status;
	
	public ResponseBean() {
		
	}
	
	public ResponseBean(String dbName, List<UserBean> userList) {
		super();
		this.dbName = dbName;
		this.userList = userList;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
