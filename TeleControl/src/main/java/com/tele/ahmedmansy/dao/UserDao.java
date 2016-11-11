package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByPhoneID(String phone_id);
	
	User findByEmail(String email);
	
	void save(User user);
	
	void deleteByPhoneID(String phone_id);
	
	void deleteByID(String id);
	
	void deleteByEmail(String email);
	
	List<User> findAllUsers();

}

