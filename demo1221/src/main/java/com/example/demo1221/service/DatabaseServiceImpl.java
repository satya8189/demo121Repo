package com.example.demo1221.service;

import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl  implements DabaseService{
	
	public String getDatbaseName(String value) {
		String dbName="";
		switch (value) {
		case "oracle":
			dbName="Oracle Database";
			break;
		case "mysql":
			dbName="MySql Database";
			break;
		case "postgresql":
			dbName="Postgresql Database";
			break;
		case "mongo":
			dbName="Mongo Database";
			break;
		default:
			dbName="No Database";
		}
		
		return dbName;
	}

}
