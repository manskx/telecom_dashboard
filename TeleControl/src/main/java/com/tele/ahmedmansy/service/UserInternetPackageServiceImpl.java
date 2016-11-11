package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.UserInternetPackageDao;
import com.tele.ahmedmansy.model.UserInternetPackage;;


@Service("userinternetPackageService")
@Transactional
public class  UserInternetPackageServiceImpl implements UserInternetPackageService{

	@Autowired
	private UserInternetPackageDao dao;

	
	
	public UserInternetPackage findById(int id) {
		return dao.findById(id);
	}

	
	public List<UserInternetPackage> getInternetPackageIDBYUserID(Integer UserID){
		return dao.findAllUsersInternetPackageByUserID(UserID);
	}

	public UserInternetPackage getActivatedUsersInternetPackageByUserID(Integer UserID){
		return dao.findActivatedUsersInternetPackageByUserID(UserID);
	}
	
	public void saveUserInternetPackage(UserInternetPackage userinternetPackage) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date date = new Date();
		userinternetPackage.setRegDate(date);
		
		dao.save(userinternetPackage);
	}
	
	public boolean ifUserSubscribedBefore(Integer UserID){
		if(getActivatedUsersInternetPackageByUserID(UserID)!=null)
			return true;
		return false;
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUserInternetPackage(UserInternetPackage userinternetPackage) {
		UserInternetPackage entity = dao.findById(userinternetPackage.getId());
		if(entity!=null){
			entity.setUserID(userinternetPackage.getUserID());
			entity.setInternetPackageID(userinternetPackage.getInternetPackageID());
			entity.setActivated(userinternetPackage.isActivated());
		}
	}

	public void deleteUserInternetPackageByID(String id){
		dao.deleteByID(id);
	}

	public List<UserInternetPackage> findAllUserInternetPackage() {
		return dao.findAllUsersInternetPackage();
	}


	
}
