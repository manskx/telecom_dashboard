package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.SmsCallPackage;;


public interface SmsCallPackageService {
	
	SmsCallPackage findById(int id);
	
	
	void saveSmsCallPackage(SmsCallPackage smsCallPackage);
	
	void updateSmsCallPackage(SmsCallPackage smsCallPackage);
	
	void deleteSmsCallPackageByID(String id);
	

	List<SmsCallPackage> findAllSmsCallPackages(); 
	



}