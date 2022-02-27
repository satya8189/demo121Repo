package com.example.demo1221.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1221.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

	

}
