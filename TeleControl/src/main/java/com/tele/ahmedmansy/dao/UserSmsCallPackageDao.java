package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.UserSmsCallPackage;;


public interface UserSmsCallPackageDao {

	UserSmsCallPackage findById(int id);
	
	void save(UserSmsCallPackage userSmsCallPackage);
	
	void deleteByID(String id);
	
	List<UserSmsCallPackage> findAllUsersSmsCallPackage();
	
	List<UserSmsCallPackage> findAllUsersSmsCallPackageByUserID(Integer UserID);
	
	UserSmsCallPackage findActivatedUsersSmsCallPackageByUserID(Integer UserID);

}

