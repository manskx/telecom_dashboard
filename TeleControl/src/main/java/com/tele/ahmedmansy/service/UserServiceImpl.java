package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.UserDao;
import com.tele.ahmedmansy.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByPhoneID(String phone_id) {
		User user = dao.findByPhoneID(phone_id);
		return user;
	}

	public User findByEmail(String email) {
		User user = dao.findByEmail(email);
		return user;
	}
	
	public void saveUser(User user) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		user.setRegDate(date);
		user.setType("USER");
		user.setCredit(0);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.print(user.getType());
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setPhoneID(user.getPhoneID());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setLostpassanswer(user.getLostpassanswer());
			entity.setName(user.getName());
			entity.setEmail(user.getEmail());
			entity.setType(user.getType());
			entity.setCredit(user.getCredit());
		}
	}

	public void deleteUserByID(String id){
		dao.deleteByID(id);
	}
	public void deleteUserByPhoneID(String phone_id) {
		dao.deleteByPhoneID(phone_id);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserPhoneIDUnique(Integer id, String phone_id) {
		User user = findByPhoneID(phone_id);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
	public boolean isUserEmailUnique(Integer id, String email){
		User user = findByEmail(email);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	public boolean ifHasEnoughCredit(Integer id, Integer fees){
		User user = findById(id);
		if(user.getCredit()<fees)
			return false;
		return true;

	}

}
