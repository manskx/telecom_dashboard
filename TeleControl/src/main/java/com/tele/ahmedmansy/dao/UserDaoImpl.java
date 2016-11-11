package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.User;



@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			//Hibernate.initialize(user.getInternetPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return user;
	}

	public User findByPhoneID(String phone_id) {
		logger.info("phone_id : {}", phone_id);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("phoneID", phone_id));
		User user = (User)crit.uniqueResult();
		if(user!=null){
			//Hibernate.initialize(user.getInternetPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return user;
	}
	public User findByEmail(String email){
		logger.info("email : {}", email);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		User user = (User)crit.uniqueResult();
		if(user!=null){
			//Hibernate.initialize(user.getInternetPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return user;
	}
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		
		
		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByPhoneID(String phone_id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("phoneID", phone_id));
		User user = (User)crit.uniqueResult();
		delete(user);
	}
	
	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		User user = (User)crit.uniqueResult();
		delete(user);
	}
	
	public void deleteByEmail(String email){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		User user = (User)crit.uniqueResult();
		delete(user);
	}

}
