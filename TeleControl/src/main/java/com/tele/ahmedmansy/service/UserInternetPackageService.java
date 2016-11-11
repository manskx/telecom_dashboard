package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.UserInternetPackage;;


public interface UserInternetPackageService {
	
	UserInternetPackage findById(int id);
	
	
	void saveUserInternetPackage(UserInternetPackage userinternetPackage);
	
	void updateUserInternetPackage(UserInternetPackage userinternetPackage);
	
	void deleteUserInternetPackageByID(String id);
	
	
	List<UserInternetPackage> getInternetPackageIDBYUserID(Integer UserID);

	List<UserInternetPackage> findAllUserInternetPackage(); 
	
	UserInternetPackage getActivatedUsersInternetPackageByUserID(Integer UserID);
	
	boolean ifUserSubscribedBefore(Integer UserID);

}