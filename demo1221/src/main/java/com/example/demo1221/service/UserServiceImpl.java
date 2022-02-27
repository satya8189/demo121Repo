package com.example.demo1221.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1221.entity.Company;
import com.example.demo1221.entity.Education;
import com.example.demo1221.entity.UserCompany;
import com.example.demo1221.entity.UserExt;
import com.example.demo1221.entity.Users;
import com.example.demo1221.helper.UserHelper;
import com.example.demo1221.model.EducationBean;
import com.example.demo1221.model.ResponseBean;
import com.example.demo1221.model.UserBean;
import com.example.demo1221.model.UserCompanyBean;
import com.example.demo1221.model.UserDetailsBean;
import com.example.demo1221.repository.CompanyRepository;
import com.example.demo1221.repository.CustomRepository;
import com.example.demo1221.repository.EducationRepository;
import com.example.demo1221.repository.UserCompanyRepository;
import com.example.demo1221.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
	UserRepository userRepository;
    
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    CompanyRepository companyRepository;
    
    @Autowired
    UserCompanyRepository  userCompanyRepository;
    
    @Autowired
    CustomRepository customRepository;
     
	@Override
	public List<UserBean> getUserList() {
		
		List<Users> userdbList=(List<Users>) userRepository.findAll();
	
	
		List<UserBean>  list=new ArrayList<>();
		userdbList.forEach(user->{
			UserBean userBean=new UserBean();
			UserHelper.convert(user,userBean);
			list.add(userBean);
			
		});
		
		return list;
		
	}
	public UserDetailsBean getUserBySqlReturObjectArray(Long userId){
		
		UserDetailsBean usrs=userRepository.getUserBySqlReturObjectArray(userId);
		return usrs;
	}
	
	@Override
	public UserBean getUserDetails(Long userId) {
		Users user=(Users)userRepository.findById(userId).orElse(null);
		
		//Users user=(Users)userRepository.getUserIdByHQL(userId).orElse(null);
		//Users user=(Users)userRepository.getUserBySql(userId).orElse(null);
		//List<Object[]> usrs=userRepository.getUserBySqlReturObjectArray(userId);
		
		
				UserBean userBean=new UserBean();
				//System.out.println("value--"+usrs);
		if(user!=null) {
		userBean.setFirstName(user.getFirstName());
		userBean.setLastName(user.getLastName());
		userBean.setUserId(user.getUserId());
		userBean.setEmail(user.getEmail());
		userBean.setAge(12L);
		if(user.getUserExt()!=null) {
			UserExt userExt=user.getUserExt();
			userBean.setMobileNumber(user.getUserExt().getMobileNumber());
			userBean.setPassportNumber(user.getUserExt().getPassportNumber());
			userBean.setMotherName(user.getUserExt().getMotherName());
			userBean.setFatherName(userExt.getFatherName());
		}
		
		if(user.getEducations()!=null && user.getEducations().size()>0) {
			List<EducationBean> educationList=new ArrayList<EducationBean>();
			user.getEducations().forEach(education->{
				EducationBean educationBean=new EducationBean();
				educationBean.setEducationId(education.getEducationId());
				educationBean.setPercentage(education.getPercentage());
				educationBean.setQulification(education.getQulification());
				educationList.add(educationBean);
			});
			userBean.setEducationList(educationList);
		}
		
		}
		return userBean;
	}
	
	@Override
	public UserBean getUserDetailsByEmail(String  email) {
		String firstName="abc";
		Users user=(Users)userRepository.findByEmailAndFirstName(email,firstName).orElse(null);
				UserBean userBean=new UserBean();
		if(user!=null) {
			UserHelper.convert(user,userBean);
		}
		return userBean;
	}

	@Override
	@Transactional
	public UserBean saveUser(UserBean userBean) {
		if(userBean!=null) {
		Users user=new Users();
		
		UserHelper.convert(userBean,user);
		
		UserExt userExt=new UserExt();
		userExt.setFatherName(userBean.getFatherName());
		userExt.setMotherName(userBean.getMotherName());
		userExt.setMobileNumber(userBean.getMobileNumber());
		userExt.setPassportNumber(userBean.getPassportNumber());
		userExt.setUsers(user);
		
		user.setUserExt(userExt);
		
		List<Education> educationEntityList=new ArrayList<Education>();
		if(userBean.getEducationList()!=null && userBean.getEducationList().size()>0) {
			
			userBean.getEducationList().forEach(educationBean->{
			Education edu=new Education();
			edu.setPercentage(educationBean.getPercentage());
			edu.setQulification(educationBean.getQulification());
			edu.setYearOfPassing(educationBean.getYearOfPassing());
			edu.setUsers(user);
		
			educationEntityList.add(edu);
			});
		}
		user.setEducations(educationEntityList);
		userRepository.save(user);
		}
		//after saving
		return userBean;
	}

	@Override
	@Transactional
	public ResponseBean saveUsers(List<UserBean> userBeanList) {
		
		userBeanList.forEach(userBean->{
		
			Users user=new Users();
			UserHelper.convert(userBean,user);
			userRepository.save(user);
		});
		return null;
	}

	@Override
	public UserBean userUpdate(UserBean userBean) {
		
		Users user=(Users)userRepository.findById(userBean.getUserId()).orElse(null);
		//UserHelper.convert(userBean,user);
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		userRepository.save(user);
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public UserCompanyBean saveUserCompany(UserCompanyBean userCompanyBean) {
		if(userCompanyBean!=null) {
			Users user=new Users();
			user.setEmail(userCompanyBean.getEmail());
			user.setFirstName(userCompanyBean.getEmail());
			user.setLastName(userCompanyBean.getLastName());
			user.setUserPwd(userCompanyBean.getUserPwd());
			userRepository.save(user);
			
			Company company=new Company();
			company.setCompanyName(userCompanyBean.getCompanyName());
			company.setLocation(userCompanyBean.getLocation());
			company.setHeadCount(userCompanyBean.getHeadCount());
			company.setTypeOfCompany(userCompanyBean.getTypeOfCompany());
			companyRepository.save(company);
			
			UserCompany userCompany=new UserCompany();
			
			userCompany.setUserId(user.getUserId());
			userCompany.setCompanyId(company.getCompanyId());
			
			userCompanyRepository.save(userCompany);
			
		
		
	}
		return userCompanyBean;
	}

	@Override
	public List<UserCompanyBean> allUserCompany() {
		List<UserCompany> list=(List<UserCompany>) userCompanyRepository.findAll();
		List<UserCompanyBean> userCompanyList= new ArrayList<UserCompanyBean>();
		list.forEach(uc->{
			UserCompanyBean ucOb=new UserCompanyBean();
			ucOb.setFirstName(uc.getUsers().getFirstName());
			ucOb.setCompanyName(uc.getCompany().getCompanyName());
			userCompanyList.add(ucOb);
		});
		
		return userCompanyList;
	}

	public List<Users> getUserListFromCustomRepo(Long userId){
		return customRepository.getuserListWihSql(userId);
	}
}
