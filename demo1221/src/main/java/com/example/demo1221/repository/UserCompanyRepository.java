package com.example.demo1221.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1221.entity.UserCompany;

@Repository
public interface UserCompanyRepository extends CrudRepository<UserCompany,Long> {

	
}
