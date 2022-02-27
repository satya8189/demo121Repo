package com.example.demo1221.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo1221.entity.Users;

@Repository
public class CustomRepository {
	
	 @PersistenceContext
	  protected EntityManager entityManager;
	 
	 public List<Users> getUserListHql(Long id) {
		 
			
	        Query query = this.entityManager
	                .createQuery("SELECT u FROM Users u WHERE u.userId =:userId");
	        
	        query.setParameter("userId", id);
	    
	        
	        List<Users> list = query.getResultList();
	        
	      
	        return list;
	    }
	 
	 
	 
	 public List<Users> getuserListWihSql(Long uId) {
		 
		 
	        Query query = this.entityManager
	                .createNativeQuery("SELECT * FROM `users` WHERE User_Id in(:uId)",Users.class);
	        
	        
	        List<Long > list1=new ArrayList<>();
	        list1.add(uId);
	        list1.add(2L);
	        query.setParameter("uId", list1);
	        
	        List<Users> list = query.getResultList();
	        
	      //  list.stream().map(Users::getEmail).collect(Collectors.joining(","));
	        
	        return list;
	    }
	/* public List<Users> getData(Long id) {
		 
		 CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
			 
		  CriteriaQuery<Users> cq = cb.createQuery(Users.class);
		   
		  Root<Users> userRoot = cq.from(Users.class);
		  //ListJoin<Users, UserDetails> tasks = userRoot.join(Users_.);		
		  //Join datosElementoJoin = userRoot.join("users",JoinType.LEFT);
		  //Join datosElementoJoinTreated = cb.treat(datosElementoJoin, UserDetails.class);
		 // Predicate p1=cb.equal(datosElementoJoinTreated.get("pan"),"3344e433");
		//  cq.where(p1);
		  List<Users> uList=entityManager.createQuery(cq).getResultList();
		  return uList;
		  
		  
	    }

	 
	 public Education getEducationByCriteria(Long id) {
		 
		 CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		 	 			 
		  CriteriaQuery<Education> cq = cb.createQuery(Education.class);
		 		  
		  Root<Education> item = cq.from(Education.class);
		  item.join("users");
		  
	
		  
		 // List<Predicate> predicates = new ArrayList<Predicate>();
		  
		  Predicate p1=cb.equal(item.get("educationId"),id);
		 // predicates.add(p1);
		  
		
		  cq.where(p1);
		  
		  Education list= entityManager.createQuery(cq).getSingleResult();
		 return list;
	 }
	  	 */
}
