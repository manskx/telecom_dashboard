package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.InternetPackage;


public interface InternetPackageDao {

	InternetPackage findById(int id);
	
	void save(InternetPackage internetPackage);
	
	void deleteByID(String id);
	
	List<InternetPackage> findAllInternetPackage();

}

