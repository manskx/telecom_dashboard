package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.UserSmsCallPackage;;


public interface UserSmsCallPackageService {
	
	UserSmsCallPackage findById(int id);
	
	
	void saveUserSmsCallPackage(UserSmsCallPackage usersmsCallPackage);
	
	void updateUserSmsCallPackage(UserSmsCallPackage usersmsCallPackage);
	
	void deleteUserSmsCallPackageByID(String id);
	
	
	List<UserSmsCallPackage> getSmsCallPackageIDBYUserID(Integer UserID);

	List<UserSmsCallPackage> findAllUserSmsCallPackage(); 
	
	UserSmsCallPackage getActivatedUsersSmsCallPackageByUserID(Integer UserID);
	
	boolean ifUserSubscribedBefore(Integer UserID);

}