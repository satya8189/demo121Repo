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
@Table(name = "company")
public class Company {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "Company_Id")
	    private Long companyId;
	    
	    @Column(name = "Company_Name")
	    private String companyName;
	    
	    @Column(name = "Company_shortName")
	    private String company;
	    
	    @Column(name = "Location")
	    private String location;
	    
	    @Column(name = "HeadCount")
	    private String headCount;
	   
	    
	    @Column(name = "TypeOfCompany")
	    private String typeOfCompany;
	
		public Long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getHeadCount() {
			return headCount;
		}

		public void setHeadCount(String headCount) {
			this.headCount = headCount;
		}

		public String getTypeOfCompany() {
			return typeOfCompany;
		}

		public void setTypeOfCompany(String typeOfCompany) {
			this.typeOfCompany = typeOfCompany;
		}

		
		
}
