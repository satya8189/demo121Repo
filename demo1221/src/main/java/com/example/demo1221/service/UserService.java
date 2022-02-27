package com.example.demo1221.service;

import java.util.List;

import com.example.demo1221.entity.Users;
import com.example.demo1221.model.ResponseBean;
import com.example.demo1221.model.UserBean;
import com.example.demo1221.model.UserCompanyBean;
import com.example.demo1221.model.UserDetailsBean;

public interface UserService {
	public List<UserBean> getUserList();

	public UserBean getUserDetails(Long userId);
	public UserBean getUserDetailsByEmail(String  email) ;

	public UserBean saveUser(UserBean userBean);

	public ResponseBean saveUsers(List<UserBean> userBeanList);

	public UserBean userUpdate(UserBean userBean);

	public void deleteUser(Long userId);

	public UserCompanyBean saveUserCompany(UserCompanyBean userCompanyBean);

	public List<UserCompanyBean> allUserCompany();
	
	UserDetailsBean getUserBySqlReturObjectArray(Long userId);
	
	List<Users>getUserListFromCustomRepo(Long userId);
}
