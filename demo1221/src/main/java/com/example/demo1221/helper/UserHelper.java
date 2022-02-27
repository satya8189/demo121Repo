package com.example.demo1221.helper;

import com.example.demo1221.entity.Users;
import com.example.demo1221.model.UserBean;

public class UserHelper {
	
	public static void convert(UserBean userBean , Users user) {
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setUserPwd(userBean.getUserPwd());
		user.setEmail(userBean.getEmail());
		user.setUserId(userBean.getUserId());
	}

	public static void convert(Users users, UserBean userBean) {
		userBean.setFirstName(users.getFirstName());
		userBean.setLastName(users.getLastName());
		userBean.setUserId(users.getUserId());
		userBean.setEmail(users.getEmail());
		userBean.setUserId(users.getUserId());
	}
}
