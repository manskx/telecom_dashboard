package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.UserSmsCallPackageDao;
import com.tele.ahmedmansy.model.UserSmsCallPackage;;


@Service("usersmsCallPackageService")
@Transactional
public class  UserSmsCallPackageServiceImpl implements UserSmsCallPackageService{

	@Autowired
	private UserSmsCallPackageDao dao;

	
	
	public UserSmsCallPackage findById(int id) {
		return dao.findById(id);
	}

	
	public List<UserSmsCallPackage> getSmsCallPackageIDBYUserID(Integer UserID){
		return dao.findAllUsersSmsCallPackageByUserID(UserID);
	}

	public UserSmsCallPackage getActivatedUsersSmsCallPackageByUserID(Integer UserID){
		return dao.findActivatedUsersSmsCallPackageByUserID(UserID);
	}
	
	public void saveUserSmsCallPackage(UserSmsCallPackage usersmsCallPackage) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date date = new Date();
		usersmsCallPackage.setRegDate(date);
		
		dao.save(usersmsCallPackage);
	}
	
	public boolean ifUserSubscribedBefore(Integer UserID){
		if(getActivatedUsersSmsCallPackageByUserID(UserID)!=null)
			return true;
		return false;
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUserSmsCallPackage(UserSmsCallPackage usersmsCallPackage) {
		UserSmsCallPackage entity = dao.findById(usersmsCallPackage.getId());
		if(entity!=null){
			entity.setUserID(usersmsCallPackage.getUserID());
			entity.setSmsCallPackageID(usersmsCallPackage.getSmsCallPackageID());
			entity.setActivated(usersmsCallPackage.isActivated());
		}
	}

	public void deleteUserSmsCallPackageByID(String id){
		dao.deleteByID(id);
	}

	public List<UserSmsCallPackage> findAllUserSmsCallPackage() {
		return dao.findAllUsersSmsCallPackage();
	}


	
}
