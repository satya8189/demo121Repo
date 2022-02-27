package com.example.demo1221.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1221.entity.Users;
import com.example.demo1221.exception.DemoException;
import com.example.demo1221.model.ResponseBean;
import com.example.demo1221.model.UserBean;
import com.example.demo1221.model.UserCompanyBean;
import com.example.demo1221.model.UserDetailsBean;
import com.example.demo1221.service.DabaseService;
import com.example.demo1221.service.UserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService  userServiceImpl;
	
	@Autowired
	DabaseService databaseServiceImpl;
	
	@GetMapping("/welcome")
	public String getMessage() {
		return "welcome Spring boot application";
	}
	
	@GetMapping("/welcome/{message}")
	public String getMessage(@PathVariable String message) {
		return message;
	}
	@GetMapping("/welcome1")
	public String welcome1(@RequestParam("message") String message,@RequestParam("name") String name) {
		return message+""+name;
	}
	
	@GetMapping("/userDetails/{userId}")
	public  UserBean  userDetails(@PathVariable Long userId) {
	return userServiceImpl.getUserDetails(userId);
		
	}
	@GetMapping("/userDetailsByEmail/{email}")
	public  UserBean userDetails(@PathVariable String email) {
		UserBean userBean=userServiceImpl.getUserDetailsByEmail(email);
		return userBean;
	}

	@GetMapping("/userList")
	public List<UserBean>   userList() throws DemoException {
		
		
		List<UserBean> list=userServiceImpl.getUserList();
		return  list;
		
	}
	@GetMapping("/userListRepo/{userId}")
	public   List<Users> userListRepo(@PathVariable Long userId) throws DemoException {
		
		
		return userServiceImpl.getUserListFromCustomRepo(userId);
	
		
	}
	
	@PostMapping("/saveUser")
	public UserBean saveUser(@RequestBody UserBean userBean) {
	
		return userServiceImpl.saveUser(userBean);
	}
	
	@PostMapping("/saveUsers")
	public ResponseBean saveUsers(@RequestBody List<UserBean> userBeanList) {
	
		return userServiceImpl.saveUsers(userBeanList);
	}
	
	@PutMapping("/updateUser")
	public UserBean userUpdate(@RequestBody UserBean userBean) {
	
		return userServiceImpl.userUpdate(userBean);
	}
	@DeleteMapping("/userDetails/{userId}")
	public UserBean  deleteUser(@PathVariable Long userId) {
		userServiceImpl.deleteUser(userId);
		UserBean userBean=new UserBean();
		return userBean;
	}
	@PostMapping("/saveUserCompany")
	public UserCompanyBean saveUserCompany(@RequestBody UserCompanyBean userCompanyBean) {
	
		return userServiceImpl.saveUserCompany(userCompanyBean);
	}
	@GetMapping("/allUserCompany")
	public List<UserCompanyBean>allUserCompany() {
	
		return userServiceImpl.allUserCompany();
	}
	
}
