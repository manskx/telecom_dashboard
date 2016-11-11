package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findByPhoneID(String phone_id);
	
	User findByEmail(String email);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByID(String id);
	
	void deleteUserByPhoneID(String phone_id);

	List<User> findAllUsers(); 
	
	boolean isUserPhoneIDUnique(Integer id, String phone_id);
	
	boolean isUserEmailUnique(Integer id, String email);
	
	boolean ifHasEnoughCredit(Integer id, Integer fees);

}