package com.example.demo1221.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo1221.entity.Users;
import com.example.demo1221.model.UserDetailsBean;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {

	Optional<Users> findByEmail(String email);

	Optional<Users> findByEmailAndFirstName(String email,String firstName);

	

	@Query("SELECT u FROM Users u WHERE u.userId =:id ")
	public Optional<Users>  getUserIdByHQL(@Param("id")  Long id);
	
	@Query( value="SELECT * FROM users u WHERE u.User_Id =:id " , nativeQuery = true)
	public  Optional<Users>   getUserBySql(@Param("id") Long id);
	
	@Query( value="SELECT u.User_Id as userId,u.First_Name as firstName FROM users u WHERE u.User_Id =:id " , nativeQuery = true)
	public  UserDetailsBean  getUserBySqlReturObjectArray(@Param("id") Long id);
	
	@Query( value="SELECT u.User_Id,u.First_Name FROM users u" , nativeQuery = true)
	public  List<Object[]>  getAllSqlReturObjectArray();
}
