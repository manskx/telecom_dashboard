package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.SmsCallPackage;;


public interface SmsCallPackageDao {

	SmsCallPackage findById(int id);
	
	void save(SmsCallPackage smsCallPackage);
	
	void deleteByID(String id);
	
	List<SmsCallPackage> findAllSmsCallPackage();

}

