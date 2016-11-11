package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.UserInternetPackage;;


public interface UserInternetPackageDao {

	UserInternetPackage findById(int id);
	
	void save(UserInternetPackage userInternetPackage);
	
	void deleteByID(String id);
	
	List<UserInternetPackage> findAllUsersInternetPackage();
	
	List<UserInternetPackage> findAllUsersInternetPackageByUserID(Integer UserID);
	
	UserInternetPackage findActivatedUsersInternetPackageByUserID(Integer UserID);

}

