package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.InternetPackage;


public interface InternetPackageService {
	
	InternetPackage findById(int id);
	
	
	void saveInternetPackage(InternetPackage internetPackage);
	
	void updateInternetPackage(InternetPackage internetPackage);
	
	void deleteInternetPackageByID(String id);
	

	List<InternetPackage> findAllInternetPackages(); 
	



}